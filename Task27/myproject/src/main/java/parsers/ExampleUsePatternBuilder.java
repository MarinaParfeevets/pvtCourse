package parsers;

public class ExampleUsePatternBuilder {

	public static void main(String[] args) {
		
		// Pattern Builder realized in class ApiVKData
		ApiVKData apiVKData = new ApiVKData.Builder()
				.withAccessToken("45667")
				.withEditMessage("Hello")
				.withOwnerId("12")
				.withUriBuilderDelete("XxX")
				.withVersion("7")
				.build();
		System.out.println(apiVKData.toString());
	}
}
