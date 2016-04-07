input 'jenkinsPostWithChanges.json'
parser 'JSON'
entity {
    id = eval('$.id')
    prev = eval('$.changeSet.items[*].id','java.util.List')
    url = eval('$.url')
    type = (eval('$.building')=='false')?'Jenkins building stopped':'Jenkins building started'
    data = all
    timestamp = new Date(eval('$.timestamp', 'java.lang.Long'))
}


