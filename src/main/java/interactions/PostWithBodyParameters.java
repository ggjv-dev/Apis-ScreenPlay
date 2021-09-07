package interactions;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostWithBodyParameters extends RestInteraction {

    private String resource;
    private String body;
    private Map<String, Object> header;
    private String [] pathFile,nameKeys;

    public PostWithBodyParameters(String resource, String body, Map<String, Object> header,String [] pathFile,String [] nameKeys) {
        this.resource = resource;
        this.body = body;
        this.header=header;
        this.pathFile=pathFile;
        this.nameKeys=nameKeys;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<File> archivos = new ArrayList<>();
        for(String path : pathFile ){
            archivos.add(new File(path));
        }
        RestAssured.config= RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
                setParam("http.connection.timeout",300000).
                setParam("http.socket.timeout",300000).
                setParam("http.connection-manager.timeout",300000));
        if(pathFile.length==1) {
            if(archivos.get(0).getPath().contains(".zip")){
                rest().relaxedHTTPSValidation()
                        .headers(header)
                        .multiPart(nameKeys[1], archivos.get(0), "application/octet-stream")
                        .formParam(nameKeys[0], body,"text/plain")
                        .when()
                        .post(resource);
            }
            if(archivos.get(0).getPath().contains(".xlsx")){
                rest().relaxedHTTPSValidation()
                        .headers(header)
                        .multiPart(nameKeys[1], archivos.get(0).getAbsoluteFile(), "application/vnd.ms-excel")
                        .formParam(nameKeys[0], body,"text/plain")
                        .when()
                        .post(resource);
            }
            if(archivos.get(0).getPath().contains(".txt")){
                rest().relaxedHTTPSValidation()
                        .headers(header)
                        .multiPart(nameKeys[1], archivos.get(0), "text/plain")
                        .multiPart(nameKeys[0], body,"text/plain")
                        .when()
                        .post(resource);
            }
            if(archivos.get(0).getPath().contains(".docx")){
                rest().relaxedHTTPSValidation()
                        .headers(header)
                        .multiPart(nameKeys[1], archivos.get(0), "application/msword")
                        .multiPart(nameKeys[0], body,"text/plain")
                        .when()
                        .post(resource);
            }
            if(archivos.get(0).getPath().contains(".pdf")){
                rest().relaxedHTTPSValidation()
                        .headers(header)
                        .multiPart(nameKeys[1], archivos.get(0), "application/pdf")
                        .multiPart(nameKeys[0], body,"text/plain")
                        .when()
                        .post(resource);
            }
        }
        if(pathFile.length==2) {
            rest().relaxedHTTPSValidation()
                    .headers(header)
                    .multiPart(nameKeys[1], archivos.get(0),"application/octet-stream")
                    .multiPart(nameKeys[2], archivos.get(1),"application/octet-stream")
                    .formParam(nameKeys[0], body, "text/plain")
                    .when()
                    .post(resource);
        }
        if(pathFile.length==3) {
            rest().relaxedHTTPSValidation()
                    .headers(header)
                    .multiPart(nameKeys[1], archivos.get(0), "application/octet-stream")
                    .multiPart(nameKeys[2], archivos.get(1), "application/octet-stream")
                    .multiPart(nameKeys[3], archivos.get(2), "application/octet-stream")
                    .formParam(nameKeys[0], body, "text/plain")
                    .when()
                    .post(resource);
        }
        if(pathFile.length==4) {
            rest().relaxedHTTPSValidation()
                    .headers(header)
                    .multiPart(nameKeys[1], archivos.get(0), "application/octet-stream")
                    .multiPart(nameKeys[2], archivos.get(1), "application/octet-stream")
                    .multiPart(nameKeys[3], archivos.get(2), "application/octet-stream")
                    .multiPart(nameKeys[4], archivos.get(3), "application/octet-stream")
                    .formParam(nameKeys[0], body, "text/plain")
                    .when()
                    .post(resource);
        }
    }
}