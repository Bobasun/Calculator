package com.eclipsercp.swtjface.modellayer;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private ResultOfCalculation result;
	private Map<String, Strategy> map = new HashMap<>();
	
	{
	map.put("+", new OperationAdd());
	map.put("*", new OperationMultiply());
	map.put("/", new OperationDivide());
	map.put("-", new OperationSubstract());
	}
	
	public Model() {	
	}
	
	public ResultOfCalculation getResult() {
		return result;
	}

	public void setResult(ResultOfCalculation result) {
		this.result = result;
	}
	
	public Map<String, Strategy> getMap() {
		return map;
	}

	
}
