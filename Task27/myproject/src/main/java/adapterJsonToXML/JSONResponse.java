package adapterJsonToXML;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONResponse {
	JSONObject jSONObject;

	public JSONResponse() {
	}

	public JSONResponse(JSONObject jSONObject) {
		this.jSONObject = jSONObject;
	}

	public JSONObject getJSONObject() {
		return jSONObject;
	}

	public boolean isJSONEqual(JSONObject jSONObject) {
		String actual = this.jSONObject.getJsonAsString();
		String expected = jSONObject.getJsonAsString();
		return actual.equals(expected);
	}
	
	public static String getIdFromresponse(String response) {
		if (response == null) {
			return null;
		} else {
			StringBuffer id = new StringBuffer();
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(response);
			while (m.find()) {
				id.append(m.group());
			}
			return id.toString();
		}
	}
}