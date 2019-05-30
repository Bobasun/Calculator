package com.eclipsercp.swtjface.controller;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import com.eclipsercp.swtjface.modellayer.Model;
import com.eclipsercp.swtjface.modellayer.ResultOfCalculation;
import com.eclipsercp.swtjface.modellayer.Strategy;
import com.eclipsercp.swtjface.view.Validator;
import com.eclipsercp.swtjface.view.View;

public class Controller {

	private Model model;
	private View view;
	String stringResult = "";
	InputListener inputListener = new InputListener(this);
	
	public Controller(View view, Model model){
       this.view = view;
       this.model = model;
       addEnableListener();
       addCalculateListener();
    }

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	private void addEnableListener() {
		view.checkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button button = (Button) e.widget;
				if (button.getSelection()) {
					view.buttonCalculate.setEnabled(false);
					addInputListeners();
				}
				else {
					view.buttonCalculate.setEnabled(true);
					removeInputListeners();
				}
			}	
		});
	}
	
	private void removeInputListeners() {
		view.getNumber1().removeKeyListener(inputListener);
		view.getNumber2().removeKeyListener(inputListener);
	}
	
	private class InputListener extends KeyAdapter{
		Controller controller;
		InputListener(Controller controller){
			this.controller = controller;
		}
		@Override
		public void keyReleased(KeyEvent e) {
			controller.calculate();
			view.setOutputText(stringResult);
			view.getHistoryList().add(stringResult);
		}
	}
	
	private void addInputListeners() {
	
		view.getNumber1().addKeyListener(inputListener);
		view.getNumber2().addKeyListener(inputListener);
	}
	
	private double validate(String number) {
		double local = 0;
		if (!Validator.validate(number)) {
			view.getNumber1().setText("0");
			view.getNumber2().setText("0");
		} else {
			local = Double.parseDouble(number);
		}
		return local;
	}
	
	private void addCalculateListener() {
		Controller controller = this;
			view.buttonCalculate.addSelectionListener(new SelectionAdapter() {
	    	@Override
			public void widgetSelected(SelectionEvent e) {
					controller.calculate();
					view.setOutputText(stringResult);
					view.getHistoryList().add(stringResult);
	    		}
			});
	}

	
	private void calculate() {
		
		double number1 = validate(view.getNumber1().getText());
		double number2 = validate(view.getNumber2().getText());
		String stringOperation = view.getOperation();
		Strategy operation = model.getMap().get(stringOperation);
		ResultOfCalculation result = operation.doOperation(number1, number2);
//		model.setResult(result);
		if (result.getMessage() == null) {
			stringResult = (Double.toString(result.getResult()));
		} else {
			stringResult = result.getMessage();
		}
	}
	
	
}
