package htmlconcerterapp;

public class HTMLConverterApp {

	public static void main(String[] args) {
		String html = "<h1>Grocery List </h1>\n" +
	            " <ul>\n" +
	            "    <li>Eggs</li>\n" +
	            "    <li>Milk</li>\n" +
	            "    <li>Butter</li>\n" +
	            "</ul>";
		System.out.println("HTML Converter\n\n" + "INPUT\n" + html+"\n");
		StringBuilder output = new StringBuilder();
		output.append(html);
		int startIndex = 0;
		int endIndex = 0;
		for(int i = 0 ; i < output.length(); i++) {
			if(output.charAt(i)=='<') {
				if(i > 0) {
					while(output.charAt(i-1)==' ') {
						output.delete(i-1, i);
						i--;
							}
					}	
				startIndex = i;
			}
			if(output.charAt(i)=='>') {
				endIndex = i+1;
				String parse = output.substring(startIndex, endIndex);
				if(parse.equalsIgnoreCase("<li>")) {
					output.replace(startIndex, endIndex, "*");
					i = startIndex-1;
				} else {
					output.delete(startIndex, endIndex);
					i = startIndex-1;
				}
				
				
			}
		}
		System.out.println("OUTPUT\n" + output);
	}

}
