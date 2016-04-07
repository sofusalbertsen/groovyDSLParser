import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;

public class GroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        // Prepare shell
        CompilerConfiguration config = new CompilerConfiguration();
        config.setScriptBaseClass("Base");
        GroovyShell shell = new GroovyShell(config);

        // Run script
        ClassLoader cl = GroovyScriptEngine.class.getClassLoader();
        File myFile = new File(cl.getResource("gitlab.dsl").getFile());
        Object result = shell.evaluate(myFile);
    }
}
