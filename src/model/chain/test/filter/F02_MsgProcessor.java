package model.chain.test.filter;

public class F02_MsgProcessor {
	private String msg;
	//Filter[] filters = {new HTMLFilter(), new SesitiveFilter(), new FaceFilter()};
	FilterChain fc;

	
	public String process() {	//对信息进行过滤（可以是静态也可以是动态，在这里采用动态）
		return fc.doFilter(msg);	
	}
	
	public FilterChain getFc() {
		return fc;
	}

	public void setFc(FilterChain fc) {
		this.fc = fc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
