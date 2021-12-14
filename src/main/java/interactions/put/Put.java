package interactions.put;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class Put extends RestInteraction {

    private String url;
    private Map<String, Object> headers;

    public Put(String url, Map<String, Object> headers) {
        this.url = url;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .put(url);
    }
}
