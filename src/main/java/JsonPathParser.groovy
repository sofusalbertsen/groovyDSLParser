import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import dk.itu.tracy.parser.GsonConfig;

class JsonPathParser implements Parser{
	DocumentContext dc;

    //Dummy implementation, return your JSON values here.
    @Override
    String eval(String key) {
		println dc.read(key,String.class)
      dc.read(key,String.class)
    }
	
    public <T> T eval(String key, String clazz) {
    	dc.read(key,Class.forName(clazz))
    }

	void setup(String input) {
		Configuration.setDefaults(new GsonConfig());
		dc = JsonPath.parse(input);
	}


}
