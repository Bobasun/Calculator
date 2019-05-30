package com.eclipsercp.swtjface;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.eclipsercp.swtjface.controller.Controller;
import com.eclipsercp.swtjface.modellayer.Model;
import com.eclipsercp.swtjface.view.View;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		View view =new View(display,shell);
		Model model = new Model();
		Controller controller = new Controller(view, model);

		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
}
