class StringCompress {
	public static void main(String args[]) {
		String input = args[0];
		System.out.println(compress(input));
	}

	public static String compress(String str) {
		boolean same;
		int count = 1;
		String temp = "";
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				same = true;
				count++;
			}
			else{
				same = false;
			}
			if(!same) {
				temp = temp + str.charAt(i-1) + count;
				count = 1;
			}
		}
		temp = temp + str.charAt(str.length()-1) + count;
		if(temp.length() < str.length()) return temp;
		else return str;
	}
}