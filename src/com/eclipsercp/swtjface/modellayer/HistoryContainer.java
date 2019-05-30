package com.eclipsercp.swtjface.modellayer;

import java.util.ArrayList;
import java.util.List;

public class HistoryContainer {

	private List<Double> list = new ArrayList<>();
	
	public HistoryContainer() {	
	}
	
	public void addItemToContainer(double number) {
		list.add(number);
	}
	
	public List<Double> getAllItems() {
		return list;	
	}
	
}
