import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilerConfiguration;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.List;

public class GroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        ClassLoader cl = GroovyScriptEngine.class.getClassLoader();
        System.out.println(cl.getResource("test.dsl").getFile());

        // Prepare shell
        CompilerConfiguration config = new CompilerConfiguration();
        config.setScriptBaseClass("Base");
        GroovyShell shell = new GroovyShell(config);

        // Run script
        File myFile = new File(cl.getResource("test.dsl").getFile());
        Object result = shell.evaluate(myFile);
    }
}
