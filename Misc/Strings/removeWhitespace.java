
public string removeWhiteSpace(string s) {
	StringBuilder b = new StringBuilder();

	for(int i = 0; i < s.length(); i++) {
		if(s.charAt(i) != ' ' && s.charAt(i) != '\n' && s.charAt(i) != '\t')
			b.append(s.charAt(i));
	}
	return b;
}
