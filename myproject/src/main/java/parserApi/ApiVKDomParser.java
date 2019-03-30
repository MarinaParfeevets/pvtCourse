package parserApi;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApiVKDomParser {
	public List<ApiVKData> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("apiVKData");
		List<ApiVKData> apiVKDataList = new ArrayList<ApiVKData>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			apiVKDataList.add(getApiVKData(nodeList.item(i)));
		}
		return apiVKDataList;
	}

	private static ApiVKData getApiVKData(Node node) {
		ApiVKData apiVKData = new ApiVKData();
		Element element = (Element) node;
		apiVKData.setAccessToken(getTagValue("accessToken", element));
		apiVKData.setOwnerId(getTagValue("ownerId", element));
		apiVKData.setVersion(getTagValue("version", element));
		apiVKData.setNewMessage(getTagValue("newMessage", element));
		apiVKData.setEditMessage(getTagValue("editMessage", element));
		apiVKData.setUriBuilderPost(getTagValue("uriBuilderPost", element));
		apiVKData.setUriBuilderEdit(getTagValue("uriBuilderEdit", element));
		apiVKData.setUriBuilderDelete(getTagValue("uriBuilderDelete", element));
		apiVKData.setPhotoId(getTagValue("photoId", element));
		return apiVKData;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
