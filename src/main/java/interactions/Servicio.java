package interactions;

import interactions.delete.*;
import interactions.delete.Delete;
import interactions.get.*;
import interactions.get.Get;
import interactions.post.*;
import interactions.post.Post;
import interactions.put.*;
import net.serenitybdd.screenplay.Interaction;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Servicio {

    private Servicio() {
    }

    /*
            DELETE
     */

    public static Interaction delete(String url, Map<String , Object> headers){
        return instrumented(Delete.class, url, headers);
    }

    public static Interaction deleteBodyHtml(String url, String body, Map<String , Object> headers){
        return instrumented(DeleteBodyHtml.class, url, body, headers);
    }

    public static Interaction deleteBodyJS(String url, String body, Map<String , Object> headers){
        return instrumented(DeleteBodyJS.class, url, body, headers);
    }

    public static Interaction deleteBodyJson(String url, String body, Map<String , Object> headers){
        return instrumented(DeleteBodyJson.class, url, body, headers);
    }

    public static Interaction deleteBodyTxt(String url, String body, Map<String , Object> headers){
        return instrumented(DeleteBodyTxt.class, url, body, headers);
    }

    public static Interaction deleteBodyXml(String url, String body, Map<String , Object> headers){
        return instrumented(DeleteBodyXml.class, url, body, headers);
    }

    public static Interaction deleteFormData(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(DeleteFormData.class, url, params, headers);
    }

    public static Interaction deleteQueryParams(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(DeleteQueryParams.class, url, params, headers);
    }

    public static Interaction deleteUrlEncoded(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(DeleteUrlEncoded.class, url, params, headers);
    }

    /*
            GET
     */

    public static Interaction get(String url, Map<String , Object> headers){
        return instrumented(Get.class, url, headers);
    }

    public static Interaction getBodyHtml(String url, String body, Map<String , Object> headers){
        return instrumented(GetBodyHtml.class, url, body, headers);
    }

    public static Interaction getBodyJS(String url, String body, Map<String , Object> headers){
        return instrumented(GetBodyJS.class, url, body, headers);
    }

    public static Interaction getBodyJson(String url, String body, Map<String , Object> headers){
        return instrumented(GetBodyJson.class, url, body, headers);
    }

    public static Interaction getBodyTxt(String url, String body, Map<String , Object> headers){
        return instrumented(GetBodyTxt.class, url, body, headers);
    }

    public static Interaction getBodyXml(String url, String body, Map<String , Object> headers){
        return instrumented(GetBodyXml.class, url, body, headers);
    }

    public static Interaction getFormData(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(GetFormData.class, url, params, headers);
    }

    public static Interaction getQueryParams(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(GetQueryParams.class, url, params, headers);
    }

    public static Interaction getUrlEncoded(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(GetUrlEncoded.class, url, params, headers);
    }

    /*
            POST
     */

    public static Interaction post(String url, Map<String , Object> headers){
        return instrumented(Post.class, url, headers);
    }

    public static Interaction postBodyHtml(String url, String body, Map<String , Object> headers){
        return instrumented(PostBodyHtml.class, url, body, headers);
    }

    public static Interaction postBodyJS(String url, String body, Map<String , Object> headers){
        return instrumented(PostBodyJS.class, url, body, headers);
    }

    public static Interaction postBodyJson(String url, String body, Map<String , Object> headers){
        return instrumented(PostBodyJson.class, url, body, headers);
    }

    public static Interaction postBodyTxt(String url, String body, Map<String , Object> headers){
        return instrumented(PostBodyTxt.class, url, body, headers);
    }

    public static Interaction postBodyXml(String url, String body, Map<String , Object> headers){
        return instrumented(PostBodyXml.class, url, body, headers);
    }

    public static Interaction postFormData(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PostFormData.class, url, params, headers);
    }

    public static Interaction postQueryParams(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PostQueryParams.class, url, params, headers);
    }

    public static Interaction postUrlEncoded(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PostUrlEncoded.class, url, params, headers);
    }

    /*
            PUT
     */

    public static Interaction put(String url, Map<String , Object> headers){
        return instrumented(Put.class, url, headers);
    }

    public static Interaction putBodyHtml(String url, String body, Map<String , Object> headers){
        return instrumented(PutBodyHtml.class, url, body, headers);
    }

    public static Interaction putBodyJS(String url, String body, Map<String , Object> headers){
        return instrumented(PutBodyJS.class, url, body, headers);
    }

    public static Interaction putBodyJson(String url, String body, Map<String , Object> headers){
        return instrumented(PutBodyJson.class, url, body, headers);
    }

    public static Interaction putBodyTxt(String url, String body, Map<String , Object> headers){
        return instrumented(PutBodyTxt.class, url, body, headers);
    }

    public static Interaction putBodyXml(String url, String body, Map<String , Object> headers){
        return instrumented(PutBodyXml.class, url, body, headers);
    }

    public static Interaction putFormData(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PutFormData.class, url, params, headers);
    }

    public static Interaction putQueryParams(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PutQueryParams.class, url, params, headers);
    }

    public static Interaction putUrlEncoded(String url, Map<String , Object> params, Map<String , Object> headers){
        return instrumented(PutUrlEncoded.class, url, params, headers);
    }
}
