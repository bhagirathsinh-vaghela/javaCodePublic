import java.util.ArrayList;
import java.util.Collections;

class StringPermutation {
	public static void main(String args[]) {
		String str = args[0];
		ArrayList<String> temp = Example.permutation(str);
		Collections.sort(temp);
		for(String s : temp) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> permutation(String input) {
		if(input.length() != 1) {
			ArrayList<String> temp = new ArrayList<>();
			for(String s : permutation(input.substring(1))) {
				for(int i = 0; i < s.length(); i++)
				{
					temp.add(s.substring(0, i) + input.charAt(0) + s.substring(i));
				}
				temp.add(s + input.charAt(0));
			}
			return temp;
		}
		ArrayList<String> temp = new ArrayList<>();
		temp.add(input);
		return temp;
	}
}