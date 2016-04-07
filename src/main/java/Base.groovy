import java.awt.im.InputContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Base extends Script {
	List<Entity> entities = new ArrayList<Entity>();
    Parser parser
	
    ClassLoader cl = Base.class.getClassLoader();
	String fileContents;
	
    Entity entity(Closure myClosure){
		Entity myConfig = new Entity();
		ContextHelper.executeInContext(myClosure, myConfig);
		entities.add(myConfig);
		println(myConfig)
		return myConfig
	}
	def String getAll(){
		//TODO: get the file content in another way
		fileContents
	}
    def eval(String key){
        return parser.eval(key)
    }
	def eval(String key,String returntype){
		return parser.eval(key,returntype)
	}
	void input(String filename){
		println filename
		fileContents = new File(cl.getResource(filename).getFile()).getText('UTF-8')
	}
    void parser(String name){
        if(name.equalsIgnoreCase('json')){
            parser = new JsonPathParser()
			parser.setup(fileContents)
			}
        else{
            println "Parser $name not supported!"
            System.exit(1)
        }
    }
}
