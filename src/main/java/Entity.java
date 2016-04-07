



import java.util.Arrays;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
/**
 *
 * @author sofus
 */
public class Entity {
    private String id;
    private String[] prev;
    private String url;
    private String type;
    private Date timestamp;
    private JsonElement data;
    private String toolname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getPrev() {
        return prev;
    }

    public void setPrev(String[] prev) {
        this.prev = prev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
    public void setData(String data){
    	JsonElement je = new JsonPrimitive(data);
    	this.data=je;
    }

	public String getToolname() {
		return toolname;
	}

	public void setToolname(String toolname) {
		this.toolname = toolname;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Entity [id=" + id + ", prev="
				+ (prev != null ? Arrays.asList(prev).subList(0, Math.min(prev.length, maxLen)) : null) + ", url=" + url
				+ ", type=" + type + ", timestamp=" + timestamp + ", data=" + data + ", toolname=" + toolname + "]";
	}
}

