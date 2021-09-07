/**
 * @since 27/11/2017
 */
package runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import util.BeforeSuite;

/**
 * Personalización del Runner con el cual se puede determinar que busque y modifique los .feature antes de ser ejecutados
 * @since 27/11/2017
 * @author bgaona
 *
 */
public class RunnerPersonalizado extends Runner {
	 
	 private Class<CucumberWithSerenity> classValue;
	 private CucumberWithSerenity cucumberWithSerenity;
	 
	 
	 public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws Exception {
	        this.classValue = classValue;
	        cucumberWithSerenity = new CucumberWithSerenity(classValue);
	    }
	 
	  @Override
	    public Description getDescription() {
	        return cucumberWithSerenity.getDescription();
	    }
	  
	  private void runAnnotatedMethods(Class<?> annotation) throws Exception {
	        if (!annotation.isAnnotation()) {
	            return;
	        }
	        Method[] methods = this.classValue.getMethods();
	        for (Method method : methods) {
	            Annotation[] annotations = method.getAnnotations();
	            for (Annotation item : annotations) {
	                if (item.annotationType().equals(annotation)) {
	                    method.invoke(null);
	                    break;
	                }
	            }
	        }
	  }
	  
	  @Override
	    public void run(RunNotifier notifier) {
	        try {
	            runAnnotatedMethods(BeforeSuite.class);
	            cucumberWithSerenity = new CucumberWithSerenity(classValue);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        cucumberWithSerenity.run(notifier);
	    }
}

