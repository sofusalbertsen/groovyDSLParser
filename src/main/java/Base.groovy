import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser


import java.awt.im.InputContext;
import java.text.DateFormat
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date
import java.util.Properties



public abstract class Base extends Script {
	Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
	public List<Entity> entities = new ArrayList<Entity>()
    Parser parser
    ClassLoader cl = Base.class.getClassLoader()
	String fileContents
	
    Entity entity(Closure myClosure){
		Entity myConfig = new Entity();
		ContextHelper.executeInContext(myClosure, myConfig);
		entities.add(myConfig);
		println(myConfig)
		return myConfig
	}
	def JsonObject getAll(){
		//TODO: get the file content in another way
		new JsonParser().parse(fileContents).getAsJsonObject();
		
	}
    def eval(String key){
        return parser.eval(key)
    }
	def eval(String key,String returntype){
		switch (returntype.toLowerCase())
		{	//to ease the expressibility of the DSL code
			case 'list':returntype='java.util.List';break;
			case 'string':returntype='java.lang.String';break;
			case 'long':returntype='java.lang.Long';break;
			case 'boolean':returntype='java.lang.Boolean';break;
			default:break;
		}
		return parser.eval(key,returntype)
	}
	void input(String filename){
		println filename
		fileContents = new File(cl.getResource(filename).getFile()).getText('UTF-8')
	}
	Date parseDate(String date, String format) throws ParseException {
		final DateFormat df = new SimpleDateFormat(format)
		df.parse(date)
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
