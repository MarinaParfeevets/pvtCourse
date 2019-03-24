package parsers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Countries;

public class DomParser {
	public List<Countries> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("Country");
		List<Countries> countries = new ArrayList<Countries>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			countries.add(getCountry(nodeList.item(i)));
		}
		return countries;
	}

	private static Countries getCountry(Node node) {
		Countries country = new Countries();
		Element element = (Element) node;
		country.setId(Integer.parseInt(element.getAttribute("id")));
		country.setCode(getTagValue("Code", element));
		country.setName(getTagValue("Name", element));
		country.setDescription(getTagValue("Description", element));
		return country;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
