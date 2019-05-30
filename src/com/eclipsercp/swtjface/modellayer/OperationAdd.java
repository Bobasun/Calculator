package com.eclipsercp.swtjface.modellayer;

public class OperationAdd implements Strategy{

	@Override
	public ResultOfCalculation doOperation(double num1, double num2) {
		ResultOfCalculation result = new ResultOfCalculation();
		result.setResult(num1+num2);
		return result;
//		return num1 + num2;
	}

}
