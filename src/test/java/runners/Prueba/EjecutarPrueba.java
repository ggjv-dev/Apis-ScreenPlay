package runners.Prueba;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import runners.RunnerPersonalizado;
import util.BeforeSuite;
import util.DataToFeature;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features/Prueba/",
        glue = "stepdefinitions",
        snippets = SnippetType.CAMELCASE )
@RunWith(RunnerPersonalizado.class)
public class EjecutarPrueba {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/Prueba/");
    }
}
