package interactions.put;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PutBodyHtml extends RestInteraction {

    private String url;
    private String body;
    private Map<String, Object> headers;

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.HTML)
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body)
                .when()
                .put(url);
    }
}
