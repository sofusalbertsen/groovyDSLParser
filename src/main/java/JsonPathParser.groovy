class JsonPathParser implements Parser{

    //Dummy implementation, return your JSON values here.
    @Override
    Object eval(String key) {
        if(key == null) return "NAN"
        if(key.contains('id')) return 4
        if(key.contains('author')) return "sofus albertsen"
        if(key.contains('contributors')) return ["thierry lacour", "john doe"]
        return "some value"
    }
}
