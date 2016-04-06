parser('JSON')

def myEntity = entity {
    id = eval('$.id')
    authors = eval('$.author') + ", " + eval('$.contributors[*]').join(", ")
    data = retrieveData()
    timestamp = new Date()
}

output(myEntity)

// Scrape some web API...
def retrieveData() {
    return ("http://www.praqma.com/".toURL().text.substring(0,25) + "...")
}

// Output some data to log
def output(entity){
    println "RESULT"
    println "--------------------"
    entity.properties.each {
        println it.key.toUpperCase()
        println "---"
        println it.value
        println "-------"
    }
}

