
String parser;
class Config {
	def timestamp
	def id
	def url
	def printout(){
		println(url+id)
	}
	def getTo() {
		this
	  }
	def bu(closure) {
		closure()
	}
	
	
}
def methodMissing(String name, args) {
	entity.metaClass.getMetaProperty(name).setProperty(entity, args)
  }
  
  def getEntity() {
	entity = new Config()
  }
  
