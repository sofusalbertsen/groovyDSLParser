import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;

public class GroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        // Prepare shell
        CompilerConfiguration config = new CompilerConfiguration();
        config.setScriptBaseClass("Base");
        Binding binding = new Binding();
        binding.setVariable("SRESULT", "foo"); // this one is visible in the DSL
        GroovyShell shell = new GroovyShell(binding,config);
        
        // Run script
        ClassLoader cl = GroovyScriptEngine.class.getClassLoader();
        File myFile = new File(cl.getResource("gitlab.dsl").getFile());
        Object result = shell.evaluate(myFile);
        System.out.println("From Java:");
        //but this one is not visible because it's in the baseclass scope. How to return something from the baseclass?
        System.out.println(shell.getProperty("entities"));
    }
}
