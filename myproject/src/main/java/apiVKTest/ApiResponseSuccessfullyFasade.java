package apiVKTest;

import adapterJsonToXML.JSONObject;
import adapterJsonToXML.JSONResponse;
import adapterJsonToXML.XMLResponse;
import adapterJsonToXML.XMLResponseAdapter;

public class ApiResponseSuccessfullyFasade {
	public boolean isApiResponseSuccessfully(String responseString) {
		JSONObject JSONObject = new JSONObject(responseString);
		JSONResponse jSONResponse = new JSONResponse(JSONObject);
		XMLResponse xMLResponse = new XMLResponse();
		XMLResponseAdapter XMLResponseAdapter = new XMLResponseAdapter(xMLResponse.getXMLObject());
		return jSONResponse.isJSONEqual(XMLResponseAdapter.getJSONObject());
	}
}