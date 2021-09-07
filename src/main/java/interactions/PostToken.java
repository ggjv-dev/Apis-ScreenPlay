package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

public class PostToken extends RestInteraction {
    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType("application/x-www-form-urlencoded")
                .relaxedHTTPSValidation()
                .formParam("grant_type","Value")
                .formParam("client_id", "Value")
                .formParam("client_secret", "Value")
                .when()
                .post("URL_TOKEN");
    }
}
