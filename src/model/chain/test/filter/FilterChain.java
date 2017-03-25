package model.chain.test.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements F04_Filter {
	List<F04_Filter> f04_Filters = new ArrayList<F04_Filter>();
	
	public FilterChain addFilter(F04_Filter f) {
		this.f04_Filters.add(f);
		return this;
	}
	
	public String doFilter(String str) {
		String r = str;
		for(F04_Filter f: f04_Filters) {
			r = f.doFilter(r);
		}
		return r;
	}
}
