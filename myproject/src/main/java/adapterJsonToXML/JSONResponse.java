package adapterJsonToXML;

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
}