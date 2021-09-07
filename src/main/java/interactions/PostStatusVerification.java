package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

public class PostStatusVerification extends RestInteraction {
    private String resource;
    private String body;

    public PostStatusVerification(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(body)
                .when().post(resource)
                .then().statusCode(200);
    }
}
