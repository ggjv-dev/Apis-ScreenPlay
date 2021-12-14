package task;

import interactions.Servicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.HashMap;
import java.util.Map;

public class Consumo implements Task {

    String metodo, url, body;
    Map<String, Object> headers;
    Map<String, Object> params;

    public Consumo(String metodo, String url, Map<String, Object> headers, String body, Map<String, Object> params) {
        this.metodo = metodo;
        this.body = body;
        this.url = url;
        this.headers = headers;
        this.params = params;
    }

    public static Consumo elApi(String metodo, String url, Map<String, Object> headers, String body, Map<String, Object> params) {
        return Tasks.instrumented(Consumo.class, metodo, url, headers, body, params);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (metodo) {
            /*
                    GET
             */
            case "Get":
                actor.attemptsTo(Servicio.get(url,headers));
                break;
            case "GetBodyHtml":
                actor.attemptsTo(Servicio.getBodyHtml(url,body,headers));
                break;
            case "GetBodyJS":
                actor.attemptsTo(Servicio.getBodyJS(url,body,headers));
                break;
            case "GetBodyJson":
                actor.attemptsTo(Servicio.getBodyJson(url,body,headers));
                break;
            case "GetBodyTxt":
                actor.attemptsTo(Servicio.getBodyTxt(url,body,headers));
                break;
            case "GetBodyXml":
                actor.attemptsTo(Servicio.getBodyXml(url,body,headers));
                break;
            case "GetFormData":
                actor.attemptsTo(Servicio.getFormData(url,params,headers));
                break;
            case "GetQueryParams":
                actor.attemptsTo(Servicio.getQueryParams(url,params,headers));
                break;
            case "GetUrlEncoded":
                actor.attemptsTo(Servicio.getUrlEncoded(url,params,headers));
                break;
            /*
                    POST
             */
            case "Post":
                actor.attemptsTo(Servicio.post(url,headers));
                break;
            case "PostBodyHtml":
                actor.attemptsTo(Servicio.postBodyHtml(url,body,headers));
                break;
            case "PostBodyJS":
                actor.attemptsTo(Servicio.postBodyJS(url,body,headers));
                break;
            case "PostBodyJson":
                actor.attemptsTo(Servicio.postBodyJson(url,body,headers));
                break;
            case "PostBodyTxt":
                actor.attemptsTo(Servicio.postBodyTxt(url,body,headers));
                break;
            case "PostBodyXml":
                actor.attemptsTo(Servicio.postBodyXml(url,body,headers));
                break;
            case "PostFormData":
                actor.attemptsTo(Servicio.postFormData(url,params,headers));
                break;
            case "PostQueryParams":
                actor.attemptsTo(Servicio.postQueryParams(url,params,headers));
                break;
            case "PostUrlEncoded":
                actor.attemptsTo(Servicio.postUrlEncoded(url,params,headers));
                break;
            /*
                    DELETE
             */
            case "Delete":
                actor.attemptsTo(Servicio.delete(url,headers));
                break;
            case "DeleteBodyHtml":
                actor.attemptsTo(Servicio.deleteBodyHtml(url,body,headers));
                break;
            case "DeleteBodyJS":
                actor.attemptsTo(Servicio.deleteBodyJS(url,body,headers));
                break;
            case "DeleteBodyJson":
                actor.attemptsTo(Servicio.deleteBodyJson(url,body,headers));
                break;
            case "DeleteBodyTxt":
                actor.attemptsTo(Servicio.deleteBodyTxt(url,body,headers));
                break;
            case "DeleteBodyXml":
                actor.attemptsTo(Servicio.deleteBodyXml(url,body,headers));
                break;
            case "DeleteFormData":
                actor.attemptsTo(Servicio.deleteFormData(url,params,headers));
                break;
            case "DeleteQueryParams":
                actor.attemptsTo(Servicio.deleteQueryParams(url,params,headers));
                break;
            case "DeleteUrlEncoded":
                actor.attemptsTo(Servicio.deleteUrlEncoded(url,params,headers));
                break;
            /*
                    PUT
             */
            case "Put":
                actor.attemptsTo(Servicio.put(url,headers));
                break;
            case "PutBodyHtml":
                actor.attemptsTo(Servicio.putBodyHtml(url,body,headers));
                break;
            case "PutBodyJS":
                actor.attemptsTo(Servicio.putBodyJS(url,body,headers));
                break;
            case "PutBodyJson":
                actor.attemptsTo(Servicio.putBodyJson(url,body,headers));
                break;
            case "PutBodyTxt":
                actor.attemptsTo(Servicio.putBodyTxt(url,body,headers));
                break;
            case "PutBodyXml":
                actor.attemptsTo(Servicio.putBodyXml(url,body,headers));
                break;
            case "PutFormData":
                actor.attemptsTo(Servicio.putFormData(url,params,headers));
                break;
            case "PutQueryParams":
                actor.attemptsTo(Servicio.putQueryParams(url,params,headers));
                break;
            case "PutUrlEncoded":
                actor.attemptsTo(Servicio.putUrlEncoded(url,params,headers));
                break;
        }
    }
}
