package apiVKTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import adapterJsonToXML.JSONResponse;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import parsers.ApiVKData;
import parsers.ApiVKDomParser;

public class ApiVKSteps {
	private static String idPost = null;
	private static final String API_VK_DATA_XML = "apiVKData.xml";
	private static ApiVKData apiVKData;
	private static ApiResponseSuccessfullyFasade apiResponseSuccessfully;
	private HttpClient client;
	private URIBuilder builder;
	private HttpGet request;
	private HttpResponse response;

	public ApiVKSteps() throws SAXException, IOException, ParserConfigurationException, XMLStreamException {
		client = HttpClientBuilder.create().build();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(API_VK_DATA_XML);
		List<ApiVKData> apiVKDataList = new ApiVKDomParser().parse(document);
		apiVKData = apiVKDataList.get(0);
		apiResponseSuccessfully = new ApiResponseSuccessfullyFasade();
	}

	@When("^Post message to the wall$")
	public void postMessage() throws URISyntaxException, ClientProtocolException, IOException {
		builder = new URIBuilder(apiVKData.getUriBuilderPost());
		builder.setParameter("access_token", apiVKData.getAccessToken())
				.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("message", apiVKData.getNewMessage())
				.setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		response = client.execute(request);
	}

	@Then("^Message is posted$")
	public void isMessagePosted() throws ParseException, IOException {
		String newIdResponse = EntityUtils.toString(response.getEntity());
		idPost = JSONResponse.getIdFromresponse(newIdResponse);
		Assert.assertNotNull(newIdResponse);
	}

	@When("^Edit message on the wall$")
	public void editMessage() throws URISyntaxException, ClientProtocolException, IOException {
		builder = new URIBuilder(apiVKData.getUriBuilderEdit());
		builder.setParameter("access_token", apiVKData.getAccessToken())
				.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("message", apiVKData.getEditMessage()).setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		response = client.execute(request);
	}

	@Then("^Message is edited$")
	public void isMessageEdited() throws ParseException, IOException {
		boolean isEditSuccessfull = apiResponseSuccessfully
				.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		Assert.assertTrue(isEditSuccessfull);
	}

	@When("^Delete message from the wall$")
	public void deleteMessage() throws ClientProtocolException, IOException, URISyntaxException {
		builder = new URIBuilder(apiVKData.getUriBuilderDelete());
		builder.setParameter("access_token", apiVKData.getAccessToken())
				.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		response = client.execute(request);
	}

	@Then("^Message is deleted$")
	public void isMessageDeleted() throws ParseException, IOException {
		boolean isDeleteSuccessfull = apiResponseSuccessfully
				.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		Assert.assertTrue(isDeleteSuccessfull);
	}

	@When("^Post photo by id$")
	public void postPhoto() throws ClientProtocolException, IOException, URISyntaxException {
		String ownerId = apiVKData.getOwnerId();
		builder = new URIBuilder(apiVKData.getUriBuilderPost());
		builder.setParameter("access_token", apiVKData.getAccessToken()).setParameter("owner_id", ownerId)
				.setParameter("message", apiVKData.getNewMessage())
				.setParameter("attachments", "photo" + ownerId + "_" + apiVKData.getPhotoId())
				.setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		response = client.execute(request);
	}

	@Then("^Photo is posted$")
	public void isPhotoPosted() throws ParseException, IOException {
		String newIdResponse = EntityUtils.toString(response.getEntity());
		Assert.assertNotNull(newIdResponse);
	}
}