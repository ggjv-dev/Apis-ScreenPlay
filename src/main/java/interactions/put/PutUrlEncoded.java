package interactions.put;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PutUrlEncoded extends RestInteraction {

    private String url;
    private Map<String, Object> params;
    private Map<String, Object> headers;

    public PutUrlEncoded(String url, Map<String, Object> params, Map<String, Object> headers) {
        this.url = url;
        this.params = params;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.URLENC)
                .relaxedHTTPSValidation()
                .headers(headers)
                .formParams(params)
                .when()
                .put(url);
    }
}
