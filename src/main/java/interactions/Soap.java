package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

public class Soap extends RestInteraction {

    private String resource;
    private String bodyRequest;

    public Soap(String resource, String bodyRequest) {
        this.resource = resource;
        this.bodyRequest = bodyRequest;
    }

    @Step("{0} executes a SOAP on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.XML)
                .relaxedHTTPSValidation()
                .body(bodyRequest)
                .when()
                .post(resource);
    }
}
