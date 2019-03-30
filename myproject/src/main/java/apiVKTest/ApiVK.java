package apiVKTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import interfaces.IInitial;
import parserApi.ApiVKData;
import parserApi.ApiVKDomParser;

public class ApiVK implements IInitial {
	private URIBuilder builder;
	private HttpGet request;
	private HttpResponse response;
	private HttpClient client;

	public ApiVK() {

	}

	public ApiVKData getDataFromXml() throws Throwable {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			throw e1;
		}
		Document document;
		try {
			document = dBuilder.parse(API_VK_DATA_XML);
		} catch (SAXException | IOException e) {
			throw e;
		}
		List<ApiVKData> apiVKDataList;
		try {
			apiVKDataList = new ApiVKDomParser().parse(document);
		} catch (FileNotFoundException | XMLStreamException ex) {
			throw ex;
		}
		return apiVKDataList.get(0);
	}

	public HttpResponse postToWall(ApiVKData apiVKData) throws Throwable {
		try {
			client = HttpClientBuilder.create().build();
			builder = new URIBuilder(apiVKData.getUriBuilderPost());
			builder.setParameter("access_token", apiVKData.getAccessToken())
					.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("message", apiVKData.getNewMessage())
					.setParameter("v", apiVKData.getVersion());
			request = new HttpGet(builder.build());
			response = client.execute(request);
		} catch (URISyntaxException | IOException ex) {
			throw ex;
		}
		return response;
	}

	public String getIdFromResponse(HttpResponse response) throws Throwable {
		String newIdResponse;
		try {
			newIdResponse = EntityUtils.toString(response.getEntity());
		} catch (ParseException | IOException e) {
			throw e;
		}
		if (newIdResponse == null) {
			return null;
		} else {
			StringBuffer id = new StringBuffer();
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(newIdResponse);
			while (m.find()) {
				id.append(m.group());
			}
			return id.toString();
		}
	}

	public HttpResponse editToWall(ApiVKData apiVKData, String idPost) throws URISyntaxException, IOException {
		client = HttpClientBuilder.create().build();
		try {
			builder = new URIBuilder(apiVKData.getUriBuilderEdit());
		} catch (URISyntaxException ex) {
			throw ex;
		}
		builder.setParameter("access_token", apiVKData.getAccessToken())
				.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("message", apiVKData.getEditMessage()).setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return response;
	}

	public HttpResponse deletePostFromWall(ApiVKData apiVKData, String idPost) throws IOException, URISyntaxException {
		client = HttpClientBuilder.create().build();
		try {
			builder = new URIBuilder(apiVKData.getUriBuilderDelete());
		} catch (URISyntaxException ex) {
			throw ex;
		}
		builder.setParameter("access_token", apiVKData.getAccessToken())
				.setParameter("owner_id", apiVKData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		try {
			response = client.execute(request);
		} catch (IOException e) {
			throw e;
		}
		return response;
	}

	public HttpResponse postPhoto(ApiVKData apiVKData) throws IOException, URISyntaxException {
		String ownerId = apiVKData.getOwnerId();
		client = HttpClientBuilder.create().build();
		try {
			builder = new URIBuilder(apiVKData.getUriBuilderPost());
		} catch (URISyntaxException ex) {
			throw ex;
		}
		builder.setParameter("access_token", apiVKData.getAccessToken()).setParameter("owner_id", ownerId)
				.setParameter("message", apiVKData.getNewMessage())
				.setParameter("attachments", "photo" + ownerId + "_" + apiVKData.getPhotoId())
				.setParameter("v", apiVKData.getVersion());
		request = new HttpGet(builder.build());
		try {
			response = client.execute(request);
		} catch (IOException e) {
			throw e;
		}
		return response;
	}
}
