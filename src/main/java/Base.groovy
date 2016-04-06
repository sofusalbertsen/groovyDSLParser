
public class Base {
	List<Entity> entities = []

	def entity(Closure myClosure){
		def myConfig = new Entity()
		executeInContext(myClosure, myConfig)
		entities.add(myConfig)
	}
}
