parser('JSON')

def myEntity = entity {
    id = eval('$.id')
    prev = eval('$.changeSet.items[*].id','java.util.List')
    url = eval('$.url')
    type = (eval('$.building')=='false')?'Jenkins building stopped':'Jenkins building started'
    data = all
    timestamp = new Date(eval('$.timestamp', 'java.lang.Long'))
}
//iff(eval('$.building'),'false',)
//list.each {
//	println it
//}


