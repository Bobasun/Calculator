package com.eclipsercp.swtjface.modellayer;

public class OperationMultiply implements Strategy{

	@Override
	public ResultOfCalculation doOperation(double num1, double num2) {
		ResultOfCalculation result = new ResultOfCalculation();
		result.setResult(num2*num1);
		return result;
	}

}
