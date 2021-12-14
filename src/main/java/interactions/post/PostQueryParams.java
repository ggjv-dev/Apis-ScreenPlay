package interactions.post;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PostQueryParams extends RestInteraction {

    private String url;
    private Map<String, Object> params;
    private Map<String, Object> headers;

    public PostQueryParams(String url, Map<String, Object> params, Map<String, Object> headers) {
        this.url = url;
        this.params = params;
        this.headers = headers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .headers(headers)
                .queryParams(params)
                .when()
                .post(url);
    }
}
