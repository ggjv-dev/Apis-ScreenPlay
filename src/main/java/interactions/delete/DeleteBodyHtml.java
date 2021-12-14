package interactions.delete;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class DeleteBodyHtml extends RestInteraction {
    private String url;
    private String body;
    private Map<String, Object> headers;

    public DeleteBodyHtml(String url, String body, Map<String, Object> headers) {
        this.url = url;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.HTML)
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(body)
                .when()
                .delete(url);
    }
}
