input 'GitlabPushWebHook2.json'
parser 'JSON'

entity {
    id = eval('$.before')+eval('$.after')
    prev = "" 
    url = eval('$.repository.homepage')
    type = eval('$.object_kind')
    data = all
    timestamp = new Date()
}
list = eval('$.commits[*].id','java.util.List')
println list
list.each {
	println it
}
//$.commits[?(@.id=="b4363fd684931d7a40ad8bd01f3f2f60c98f40a9")]
list.each {
entity {
    id = eval('$.before')+eval('$.after')
    prev = "" 
    url = eval('$.repository.homepage')
    type = eval('$.object_kind')
    data = all
    timestamp = eval('$.commits[?(@.id=='+it+')].timestamp','java.util.Date')
}
}

