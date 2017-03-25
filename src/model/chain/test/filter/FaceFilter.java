package model.chain.test.filter;

public class FaceFilter implements F04_Filter {

	@Override
	public String doFilter(String str) {
		return str.replace(":)", "^V^");
	}

}
