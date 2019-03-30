package parserEmail;

public class NewEmailInfo {
	private String recievers;
	private String subject;
	private String textOfLetter;

	public NewEmailInfo() {

	}

	public String getRecievers() {
		return recievers;
	}

	public void setRecievers(String recievers) {
		this.recievers = recievers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextOfLetter() {
		return textOfLetter;
	}

	public void setTextOfLetter(String textOfLetter) {
		this.textOfLetter = textOfLetter;
	}
}
