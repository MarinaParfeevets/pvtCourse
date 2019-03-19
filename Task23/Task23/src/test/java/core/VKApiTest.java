package core;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VKApiTest {
	private String accessToken = "dbf07b2af89238202021febbafb8303fb3e2f7aa36cd8703966205cceeeddee53be96a448acce0404ca";
	private String ownerId = "6576383";
	private String version = "5.92";
	private String uriBuilderPost = "https://api.vk.com/method/wall.post?";
	private String uriBuilderEdit = "https://api.vk.com/method/wall.edit?";
	private String uriBuilderDelete = "https://api.vk.com/method/wall.delete?";
	private String idPost;
	private String IdEdit = "619";
	private String IdDelete = "614";

	private HttpClient client;
	private URIBuilder builder;
	private HttpGet request;
	private HttpResponse response;

	@Before
	public void setUp() throws URISyntaxException, ClientProtocolException, IOException {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSendMessage() throws URISyntaxException, ClientProtocolException, IOException {
		client = HttpClientBuilder.create().build();
		builder = new URIBuilder(uriBuilderPost);
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("message", "spam").setParameter("v", version);
		request = new HttpGet(builder.build());
		response = client.execute(request);
		String newIdResponse = EntityUtils.toString(response.getEntity());
		idPost = VKApiWall.getIdFromresponse(newIdResponse);
		Assert.assertNotNull(newIdResponse);
	}

	@Test
	public void testEditMessage() throws URISyntaxException, ClientProtocolException, IOException {
		client = HttpClientBuilder.create().build();
		builder = new URIBuilder(uriBuilderEdit);
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", IdEdit).setParameter("message", "after edit").setParameter("v", version);
		request = new HttpGet(builder.build());
		response = client.execute(request);
		boolean isEditPost = VKApiWall.isResponseEqualsTo(EntityUtils.toString(response.getEntity()));
		Assert.assertTrue(isEditPost);
	}

	@Test
	public void testDeleteMessage() throws URISyntaxException, ClientProtocolException, IOException {
		client = HttpClientBuilder.create().build();
		builder = new URIBuilder(uriBuilderDelete);
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("post_id", IdDelete).setParameter("v", version);
		request = new HttpGet(builder.build());
		response = client.execute(request);
		boolean isDeletePost = VKApiWall.isResponseEqualsTo(EntityUtils.toString(response.getEntity()));
		Assert.assertTrue(isDeletePost);
	}

	@Test
	public void testPostPhoto() throws URISyntaxException, ClientProtocolException, IOException {
		client = HttpClientBuilder.create().build();
		builder = new URIBuilder(uriBuilderPost);
		builder.setParameter("access_token", accessToken).setParameter("owner_id", ownerId)
				.setParameter("message", "spam").setParameter("attachments", "photo" + ownerId + "_456239168")
				.setParameter("v", version);
		request = new HttpGet(builder.build());
		response = client.execute(request);
		String newIdResponse = EntityUtils.toString(response.getEntity());
		Assert.assertNotNull(newIdResponse);
	}
}