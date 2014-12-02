package net.hbclass.stone;

import java.util.HashMap;
import java.util.Map;

public class ToySpec {
	private Map<String,Object>props;

	public ToySpec() {
		props = new HashMap<String,Object>();
	}
	public enum ToyType{
		FIGURE, DOLL;
	}
	public enum ToyUser{
		ADULT, CHILD;
	}
	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}
	public Object getProps(String name) {
		return props.get(name);
	}
	public void setProps(String key, Object value) {
		props.put(key, value);
	}
	public boolean match(ToySpec spec){ // 비교검색
		String specStr = "";
		String thisStr = "";
		if(spec.getProps("ToyUser")!=null){
			specStr += spec.getProps("ToyUser");
			thisStr += getProps("ToyUser");
		}
		if(spec.getProps("ToyType")!=null){
			specStr += spec.getProps("ToyType");
			thisStr += getProps("ToyType");
		}
		return spec.equals(thisStr);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
}
