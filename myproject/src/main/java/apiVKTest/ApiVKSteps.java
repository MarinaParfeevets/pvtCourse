package apiVKTest;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import parserApi.ApiVKData;

public class ApiVKSteps {
	private static String idPost = null;
	private static ApiVKData apiVKData;
	private static ApiResponseSuccessfullyFasade apiResponseSuccessfully;
	private HttpResponse response;
	private ApiVK apiVK;
	private static final Logger log = Logger.getLogger(ApiVKSteps.class);
	private static int statusActual;
	private static final int STATUS_EXPECTED = 200;

	public ApiVKSteps() {
		apiVK = new ApiVK();
		apiResponseSuccessfully = new ApiResponseSuccessfullyFasade();
	}

	@Before("@postMessageToTheWall")
	public void starter() {
		try {
			apiVKData = apiVK.getDataFromXml();
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		log.info("Initializatioan api Data from xml finished");
	}

	@When("^Post message to the wall$")
	public void postMessage() {
		try {
			response = apiVK.postToWall(apiVKData);
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is posted$")
	public void isMessagePosted() {
		try {
			idPost = apiVK.getIdFromResponse(response);
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		statusActual = response.getStatusLine().getStatusCode();
		if (statusActual == STATUS_EXPECTED) {
			log.info("Message is posted on the wall");
		} else {
			log.error("Message is posted on the wall with error");
		}
		Assert.assertEquals(statusActual, STATUS_EXPECTED);
	}

	@When("^Edit message on the wall$")
	public void editMessage() {
		try {
			response = apiVK.editToWall(apiVKData, idPost);
		} catch (URISyntaxException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is edited$")
	public void isMessageEdited() {
		boolean isEditSuccessfull = false;
		try {
			isEditSuccessfull = apiResponseSuccessfully
					.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		if (isEditSuccessfull) {
			log.info("Message is edited on the wall");
		} else {
			log.error("Message is edited on the wall with error");
		}
		Assert.assertTrue(isEditSuccessfull);
	}

	@When("^Delete message from the wall$")
	public void deleteMessage() {
		try {
			response = apiVK.deletePostFromWall(apiVKData, idPost);
		} catch (URISyntaxException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is deleted$")
	public void isMessageDeleted() {
		boolean isDeleteSuccessfull = false;
		try {
			isDeleteSuccessfull = apiResponseSuccessfully
					.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
		}
		if (isDeleteSuccessfull) {
			log.info("Message is deleted on the wall");
		} else {
			log.error("Message is deleted from the wall with error");
		}
		Assert.assertTrue(isDeleteSuccessfull);
	}

	@When("^Post photo by id$")
	public void postPhoto() {
		try {
			response = apiVK.postPhoto(apiVKData);
		} catch (URISyntaxException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Photo is posted$")
	public void isPhotoPosted() {
		statusActual = response.getStatusLine().getStatusCode();
		if (statusActual == STATUS_EXPECTED) {
			log.info("Photo is posted on the wall");
		} else {
			log.error("Photo is posted on the wall with error");
		}
		Assert.assertEquals(statusActual, STATUS_EXPECTED);
	}
}