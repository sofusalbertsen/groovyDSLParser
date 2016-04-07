parser('JSON')

def myEntity = entity {
    id = eval('$.id')
    prev = eval('$.changeSet.items[*].id','java.util.List') 
    url = eval('$.url')
    type = 'Jenkins build started'
    data = all
    timestamp = new Date(eval('$.timestamp', 'java.lang.Long'))
}

//list.each {
//	println it
//}
