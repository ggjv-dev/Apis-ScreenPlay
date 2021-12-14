package interactions.post;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PostBodyTxt extends RestInteraction {

    private String url;
    private String body;
    private Map<String, Object> headers;

    public PostBodyTxt(String url, String body, Map<String, Object> headers) {
        this.url = url;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.TEXT)
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body)
                .when()
                .post(url);
    }
}
