package interactions.get;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class GetFormData extends RestInteraction {

    private String url;
    private Map<String, Object> params;
    private Map<String, Object> headers;

    public GetFormData(String url, Map<String, Object> params, Map<String, Object> headers) {
        this.url = url;
        this.params = params;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .headers(headers)
                .formParams(params)
                .when()
                .get(url);
    }
}
