package stepdefinitions;


import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;
import questions.LastResponseStatusCode;
import questions.Valida;
import task.Consumo;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ApisStepDefinitions extends PageObject {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        OnStage.setTheStage(new Cast());
    }

    @Given("^quiero ejecutar el API (.+) con la peticion (.+)$")
    public void quieroEjecutarElAPIConLaPeticion(String api, String peticion) {
    }

    @When("^consumo el api (.+) con la data data de prueba$")
    public void consumoElApiConLaDataDePrueba(String api, DataTable datosPeticion) throws IOException {
        List<String> datos = datosPeticion.topCells();
        String url, body, metodo;
        String[] pathFile, nameKeys;
        //Generar token
        //OnStage.theActorCalled("Token").wasAbleTo(
        //        Consumo.elApi("TOKEN",null,null,null,null,null));
        //System.out.println("Value token");
        //System.out.println(SerenityRest.lastResponse().path("access_token").toString());

        //Preparar data para el api
        url = environmentVariables.getProperty(datos.get(0)) + datos.get(1);
        body = datos.get(4);

        pathFile = datos.get(5).split("#");
        nameKeys = datos.get(6).split("#");


        metodo = datos.get(2);
        System.out.println(url);
        Map<String, String> headers = new HashMap<>();
        for (String pair : datos.get(3).split(",")) {
            String[] entry = pair.split(":");
            if (entry[0].contains("Authorization")) {
                headers.put(entry[0].trim(), "Bearer " + SerenityRest.lastResponse().path("access_token").toString());
            } else {
                headers.put(entry[0].trim(), entry[1].trim());
            }
        }

        //Consumir API
        OnStage.theActorCalled("Operador/ambos").wasAbleTo(
                Consumo.elApi(metodo, url, headers, body, pathFile, nameKeys));
    }

    @Then("^verifico el status code (\\d+)$")
    public void verificoElStatusCode(int sc) {
        System.out.println(sc);
        OnStage.theActorInTheSpotlight().should(seeThat("El status code: ", LastResponseStatusCode.is(), equalTo(sc)));
    }

    @Then("^las respuestas esperadas (.+) en las rutas (.+) del response$")
    public void lasRespuestasEsperadasEnLasRutasDelResponse(String respuestasEsperadas, String rutas) {
        System.out.println(respuestasEsperadas);
        System.out.println(rutas);
        String[] respuestasE, rutasList;
        respuestasE = respuestasEsperadas.split("#");
        rutasList = rutas.split("#");
        List<String> re;
        List<String> ru;
        re = Arrays.asList(respuestasE);
        ru = Arrays.asList(rutasList);
        OnStage.theActorInTheSpotlight().should(seeThat("Respuesta esperada", Valida.bodyRespuesta(ru), equalTo(re)));
    }
}
