package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VKApiWall {
	private static final String responseSuccessfulOperation = "{\"response\":1}";

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

	public static boolean isResponseEqualsTo(String response) {
		return response.equals(responseSuccessfulOperation);
	}
}
