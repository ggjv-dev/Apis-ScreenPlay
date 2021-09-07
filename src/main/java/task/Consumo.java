package task;

import interactions.Servicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.Map;

public class Consumo implements Task {

    String metodo, url, body;
    String []pathFile,nameKeys;
    Map<String, String> headers;
    public Consumo(String metodo, String url, Map<String, String> headers, String body,  String [] pathFile, String []  nameKeys) {
        this.metodo = metodo;
        this.body = body;
        this.url = url;
        this.headers = headers;
        this.pathFile=pathFile;
        this.nameKeys=nameKeys;
    }
    public static Consumo elApi(String metodo, String url, Map<String, String> headers, String body,String [] pathFile,String [] nameKeys) {
        return Tasks.instrumented(Consumo.class, metodo, url, headers, body,pathFile,nameKeys);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            switch(metodo){
                case "POST":
                    actor.attemptsTo(
                        Servicio.restPost(url,body,headers)
                    );
                    break;
                case "DELETE":
                    actor.attemptsTo(
                            Servicio.restDelete(url,body,headers)
                    );
                    break;
                case "GET":
                    actor.attemptsTo(
                            Servicio.restGet(url,headers)
                    );
                    break;
                case "GET-PARAMS":
                    Map<String, String> params= new HashMap<>();
                    for (String pair : body.split(",")) {
                        String[] entry = pair.split(":");
                        if(entry[1].trim().equals("vacio"))
                            params.put(entry[0].trim(), "  ");
                        else
                            params.put(entry[0].trim(), entry[1].trim());
                    }
                    actor.attemptsTo(
                            Servicio.restGetParams(url,headers,params)
                    );
                    break;
                case "PUT":
                    actor.attemptsTo(
                            Servicio.restPut(url,body,headers)
                    );
                    break;
                case "POSTWITHBODYPARAMETERS":
                    actor.attemptsTo(
                            Servicio.restPostNew(url,body,headers,pathFile,nameKeys)
                    );
                    break;
                case "TOKEN":
                    actor.attemptsTo(
                            Servicio.restToken()
                    );
            }
    }
}
