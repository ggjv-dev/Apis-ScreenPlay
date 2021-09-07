package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class GetParams extends RestInteraction {

    public GetParams(String resource, Map<String, Object> headers, Map<String, Object> params) {
        this.resource = resource;
        this.headers = headers;
        this.params = params;
    }

    private String resource;
    private Map<String, Object> headers;
    private Map<String, Object> params;
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(resource,params);
    }
}
