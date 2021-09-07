package interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Servicio {

    private Servicio() {
    }

    /**
     * @param resource ruta del recurso a consumir
     */
    public static Interaction restGet(String resource) {
        return instrumented(Get.class, resource);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restGet(String resource, Map header) {
        return instrumented(GetWithHeader.class, resource, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     */
    public static Interaction restGetVerification(String resource) {
        return instrumented(GetStatusVerification.class, resource);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restGetVerification(String resource, Map header) {
        return instrumented(GetWHStatusVerification.class, resource, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     */
    public static Interaction restPost(String resource, String body) {
        return instrumented(Post.class, resource, body);
    }
    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restPostNew(String resource, String body, Map header,String [] pathFile, String[] nameKeys) {
        return instrumented(PostWithBodyParameters.class, resource, body, header,pathFile,nameKeys);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     */
    public static Interaction restPostVerification(String resource, String body) {
        return instrumented(PostStatusVerification.class, resource, body);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restPost(String resource, String body, Map header) {
        return instrumented(PostWithHeader.class, resource, body, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restPostVerification(String resource, String body, Map header) {
        return instrumented(PostWHStatusVerification.class, resource, body, header);
    }

    /**
     * @param resource    ruta del recurso a consumir
     * @param bodyRequest String con el body del servicio a consumir
     */
    public static Interaction soap(String resource, String bodyRequest) {
        return instrumented(Soap.class, resource, bodyRequest);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restDeleteVerification(String resource, String body, Map header){
        return instrumented(DeleteStatusVerification.class, resource, body, header);
    }

    public static Interaction restDelete(String resource, String body, Map header){
        return instrumented(Delete.class, resource, body, header);
    }

    public static Interaction restPut(String url, String body, Map<String, String> headers) {
        return instrumented(PutWithHeaders.class, url,body,headers);
    }

    public static Interaction restToken() {
        return instrumented(PostToken.class);
    }

    public static Performable restGetParams(String url, Map<String, String> headers, Map<String, String> params) {
        return instrumented(GetParams.class, url, headers, params);
    }
}
