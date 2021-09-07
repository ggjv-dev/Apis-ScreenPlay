package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LastResponseStatusCode implements Question<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LastResponseStatusCode.class);

    public static LastResponseStatusCode is() {
        return new LastResponseStatusCode();
    }

    public LastResponseStatusCode() {
        // Este Metodo esta vacio porque se ejecuta lo que esta en el @Override.
    }

    @Override
    public Integer answeredBy(Actor actor) {
        LOGGER.info(lastResponse().asString());
        return lastResponse().getStatusCode();
    }
}
