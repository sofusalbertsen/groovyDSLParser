public abstract class Base extends Script {
	List<Entity> entities = new ArrayList<Entity>();
    Parser parser

    Entity entity(Closure myClosure){
		Entity myConfig = new Entity();
		ContextHelper.executeInContext(myClosure, myConfig);
		entities.add(myConfig);
		return myConfig
	}

    def eval(String key){
        return parser.eval(key)
    }

    void parser(String name){
        if(name.equalsIgnoreCase('json'))
            parser = new JsonPathParser()
        else{
            println "Parser $name not supported!"
            System.exit(1)
        }
    }
}
