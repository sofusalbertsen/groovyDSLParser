public abstract class Base extends Script {
	List<Entity> entities = new ArrayList<Entity>();

	Entity entity(Closure myClosure){
		Entity myConfig = new Entity();
		ContextHelper.executeInContext(myClosure, myConfig);
		entities.add(myConfig);
		return myConfig
	}
}
