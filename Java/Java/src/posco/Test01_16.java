package posco;

public class Test01_16 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
//		String sentence = "OneHandOpera";
//		String sentence = "EUValanceOverfitting";
		String sentence = "MyHouseNameIsKEYBoardLL";
			
		for(int i =0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			
			if(Character.isLowerCase(c)) {
				continue;
			}
			if(i==sentence.length()-1 && !Character.isLowerCase(sentence.charAt(i-1))) {
				continue;
			}
			if(i>0 && Character.isUpperCase(sentence.charAt(i-1)) && !Character.isLowerCase(sentence.charAt(i+1))) {
				continue;
			}
			sb.append(c);

		}
		System.out.println(sb);
	}

}
