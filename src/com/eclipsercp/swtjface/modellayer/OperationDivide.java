package com.eclipsercp.swtjface.modellayer;

public class OperationDivide implements Strategy{

	@Override
	public ResultOfCalculation doOperation(double num1, double num2) {
		ResultOfCalculation result = new ResultOfCalculation();
		try {
			result.setResult(num1/num2);
		} catch(ArithmeticException e) {
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
}
