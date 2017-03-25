package model.chain.test.filter;

public class SesitiveFilter implements F04_Filter {

	public String doFilter(String str) {
		//process the sensitive words
		String r = str.replace("被就业", "就业")
			 .replace("敏感", "");
		
		return r;
	}

}
