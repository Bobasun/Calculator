package com.eclipsercp.swtjface.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class View {

	private TabFolder folder;
	private Text number1;
	private Text number2;
	private Combo operations;
	private Text outputText;
	public Button buttonCalculate;
	public Button checkButton;
	private List historyList;
	private Group group1;
	

	public View(Display display, Shell shell) {
		
		shell.setText("SWT Calculator");
		shell.setSize(220, 250);
		shell.setLayout(new FillLayout());
		
		folder = new TabFolder(shell,SWT.NONE);
        TabItem tabItem1 = new TabItem(folder, SWT.NONE);
        tabItem1.setText("Calculator");
        TabItem tabItem2 = new TabItem(folder, SWT.V_SCROLL);
        tabItem2.setText("History");
 
        fillTab1();
		tabItem1.setControl(group1);

        addHistoryList();
		tabItem2.setControl(historyList);
	}
	
	private void addHistoryList() {
		historyList = new List(folder,SWT.V_SCROLL | SWT.BORDER | SWT.SINGLE);
	}
	
	private void fillTab1() {
		group1 = new Group(folder, SWT.NONE);
		number1 = new Text(group1, SWT.BORDER);
		number1.setText("0");
		number1.setBounds(10, 10, 60, 20);
		addOperations();
		number2 = new Text(group1, SWT.BORDER);
		number2.setText("0");
		number2.setBounds(130, 10, 60, 20);
		addButtons();
		outputText = new Text(group1,SWT.BORDER);
		outputText.setBounds(10, 125, 180, 30);
	}
	
	private void addOperations() {
		operations = new Combo(group1, SWT.NONE);
		operations.setText("/");
		operations.add("+");
		operations.add("-");
		operations.add("*");
		operations.add("/");
		operations.setBounds(80, 10, 40, 20);
	}
	
	private void addButtons() {
		checkButton = new Button(group1,SWT.CHECK);
		checkButton.setText("Calculate on the fly");
		checkButton.setBounds(10, 90, 120, 30);
		
		buttonCalculate = new Button(group1,SWT.PUSH);
		buttonCalculate.setText("Calculate");
		buttonCalculate.setBounds(130, 90, 60, 30);
	}

	
	public String getOperation() {
		return operations.getText();
	}
	
	public void setOutputText(String text) {
		outputText.setText(text);
	}
	
	
	public Button getButtonCalculate() {
		return buttonCalculate;
	}


	public Button getCheckButton() {
		return checkButton;
	}


	public void setNumber1(Text number1) {
		this.number1 = number1;
	}


	public void setNumber2(Text number2) {
		this.number2 = number2;
	}


	public void setButtonCalculate(Button buttonCalculate) {
		this.buttonCalculate = buttonCalculate;
	}


	public void setCheckButton(Button checkButton) {
		this.checkButton = checkButton;
	}

	public Text getNumber1() {
		return number1;
	}


	public Text getNumber2() {
		return number2;
	}

	public List getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List historyList) {
		this.historyList = historyList;
	}

	public Text getOutputText() {
		return outputText;
	}

	public void setOutputText(Text outputText) {
		this.outputText = outputText;
	}
}
