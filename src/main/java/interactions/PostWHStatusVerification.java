package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class PostWHStatusVerification extends RestInteraction {
    private String resource;
    private String body;
    private Map<String, Object> header;

    public PostWHStatusVerification(String resource, String body, Map header) {
        this.resource = resource;
        this.body = body;
        this.header = header;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .headers(header)
                .body(body)
                .when().post(resource)
                .then().statusCode(200);
    }
}
