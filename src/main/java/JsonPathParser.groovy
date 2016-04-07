import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;
import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;


class JsonPathParser implements Parser{
	DocumentContext dc;

    //Dummy implementation, return your JSON values here.
    @Override
    String eval(String key) {
//		println key
      dc.read(key,String.class)
    }
	
    public <T> T eval(String key, String clazz) {
//		println key
    	dc.read(key,Class.forName(clazz))
    }

	void setup(String input) {
		Configuration.setDefaults(new GsonConfig());
		dc = JsonPath.parse(input);
	}
	

}
