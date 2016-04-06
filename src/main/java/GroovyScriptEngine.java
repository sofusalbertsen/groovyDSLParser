// Listing 3.3 Java Application code that invokes the Groovy DSL


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class GroovyScriptEngine {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        ClassLoader cl = GroovyScriptEngine.class.getClassLoader();
        System.out.println(cl.getResource("test.dsl").getFile());
       
        
        List<?> orders =
                (List<?>)engine.eval(new InputStreamReader(
                    new BufferedInputStream(
                        new SequenceInputStream(
//                        		cl.getResourceAsStream("ClientConfig.groovy"),
                              new FileInputStream("src/main/java/Base.groovy"),
                        		cl.getResourceAsStream("test.dsl")
//                              new FileInputStream("target/classes/test.dsl")
                              ))));
//                              new FileInputStream("src/ch3/ClientOrder.groovy"),
//                              new FileInputStream("src/order.dsl")))));

//        System.out.println(orders.size());
//        for(Object o : orders) {
//            System.out.println(o);
//        }
    }
}
