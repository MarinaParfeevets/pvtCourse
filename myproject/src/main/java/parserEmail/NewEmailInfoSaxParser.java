package parserEmail;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewEmailInfoSaxParser extends DefaultHandler {
	private List<NewEmailInfo> newEmails;
	private NewEmailInfo newEmail;
	boolean bRecievers = false;
	boolean bSubject = false;
	boolean bTextOfLetter = false;

	public List<NewEmailInfo> getEmailInfo() {
		return newEmails;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("newEmailInfo")) {
			newEmail = new NewEmailInfo();
			if (newEmails == null) {
				newEmails = new ArrayList<>();
			}
		} else if (qName.equalsIgnoreCase("recievers")) {
			bRecievers = true;
		} else if (qName.equalsIgnoreCase("subject")) {
			bSubject = true;
		} else if (qName.equalsIgnoreCase("textOfLetter")) {
			bTextOfLetter = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("newEmailInfo")) {
			newEmails.add(newEmail);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (bRecievers) {
			newEmail.setRecievers(new String(ch, start, length));
			bRecievers = false;
		} else if (bSubject) {
			newEmail.setSubject(new String(ch, start, length));
			bSubject = false;
		} else if (bTextOfLetter) {
			newEmail.setTextOfLetter(new String(ch, start, length));
			bTextOfLetter = false;
		}
	}
}
