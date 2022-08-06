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
import java.util.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ApisStepDefinitions extends PageObject {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        OnStage.setTheStage(new Cast());
    }

    @When("^verifico el status code (\\d+)$")
    public void verificoElStatusCode(int sc) {
        System.out.println(sc);
        OnStage.theActorInTheSpotlight().should(seeThat("El status code: ", LastResponseStatusCode.is(), equalTo(sc)));
    }

    @Given("^consumo el api (.+) para verificar la peticion (.+), con la siguiente data de prueba:$")
    public void consumoElApiParaVerificarLaPeticionConLaSiguienteDataDePrueba(String api, String peticion, DataTable datosPeticion) throws IOException {

        List<String> datos = datosPeticion.topCells();
        String url, body, metodo;

        //Preparar url
        url = environmentVariables.getProperty(datos.get(0)) + datos.get(1);
        System.out.println(url);//Cambiar por Logger

        //Preparar body
        body = datos.get(4);

        //Indicar Metodo
        metodo = datos.get(2);

        //Preparar headers
        Map<String, Object> headers = new HashMap<>();
        for (String pair : datos.get(3).split(",")) {
            String[] entry = pair.split(":");
            headers.put(entry[0].trim(), entry[1].trim());
        }

        //Preparar parametros
        Map<String, Object> params = new HashMap<>();
        if (datos.get(5).equals("N/A")){
            System.out.println("No aplica");
        }else {
            for (String pair : datos.get(5).split(",")) {
                String[] entry = pair.split(":");
                if (entry[1].trim().equals("vacio"))
                    params.put(entry[0].trim(), "  ");
                else
                    params.put(entry[0].trim(), entry[1].trim());
            }
        }

        //Consumir API
        OnStage.theActorCalled("Gabriel").wasAbleTo(
                Consumo.elApi(metodo, url, headers, body, params));
    }

    @Then("^Verifico los valores esperados en el response (.+)$")
    public void verificoLosValoresEsperadosEnElResponse(String valoresEsperados) {

        List<String> responsePaths = new ArrayList<String>();
        List<String> respuestaEsperada = new ArrayList<String>();

        //Preparar rutas y valores esperados
        for (String pair : valoresEsperados.split("#")) {
            String[] entry = pair.split("~");
            responsePaths.add(entry[0].trim());
            respuestaEsperada.add(entry[1].trim());
        }
        OnStage.theActorInTheSpotlight().should(seeThat("Respuesta esperada"
                , Valida.bodyRespuesta(responsePaths)
                , equalTo(respuestaEsperada)));
    }
}
