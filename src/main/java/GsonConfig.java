

import java.util.EnumSet;
import java.util.Set;

import com.jayway.jsonpath.Configuration.Defaults;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

public class GsonConfig  implements Defaults{
	private final JsonProvider jsonProvider = new GsonJsonProvider();
	private final MappingProvider mappingProvider = new GsonMappingProvider();
	@Override
	public JsonProvider jsonProvider() {
		return jsonProvider;
	}
	@Override
	public MappingProvider mappingProvider() {
		return mappingProvider;
	}
	@Override
	public Set<Option> options() {
		return EnumSet.noneOf(Option.class);
	}

}
