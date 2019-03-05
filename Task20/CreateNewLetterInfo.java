package Pages;

public class CreateNewLetterInfo {
	private String recievers;
	private String subject;
	private String textOfLetter;
	
	public CreateNewLetterInfo(String recievers, String subject, String textOfLetter) {
		this.recievers=recievers;
		this.subject=subject;
		this.textOfLetter=textOfLetter;
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
