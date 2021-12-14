package interactions.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class Delete extends RestInteraction {

    private String url;
    private Map<String, Object> headers;

    public Delete(String url, Map<String, Object> headers) {
        this.url = url;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .delete(url);
    }
}
