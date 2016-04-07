input 'GitlabPushWebHook2.json'
parser 'JSON'
AMQP('AMQP.properties')
println eval('$.user_id','long')
entity {
    id = eval('$.before')+eval('$.after')
    prev = "" 
    url = eval('$.repository.homepage')
    type = eval('$.object_kind')
    data = all
    timestamp = new Date()
}
list = eval '$.commits[*].id','List'
list.eachWithIndex { val, idx ->
entity {
    id = eval('$.commits['+idx+'].id')
    prev = "" 
    url = eval('$.commits['+idx+'].url')
    type = 'commit'
    data = all
    timestamp = parseDate(eval('$.commits['+idx+'].timestamp'),"yyyy-MM-dd'T'HH:mm:ssX")
}
}
def file1 = new File('groovy1.txt')

file1.write(gson.toJson(entities))
send()

