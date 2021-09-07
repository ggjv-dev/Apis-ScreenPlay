package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PutWithHeaders extends RestInteraction {

    private String url;
    private String body;
    private Map<String, Object> headers;

    public PutWithHeaders(String url, String body, Map<String, Object> headers) {
        this.url = url;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON).relaxedHTTPSValidation()
                .headers(headers)
                .body(body)
                .when()
                .put(url);
    }
}
