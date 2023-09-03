package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.view.Frame;

public class Presenter implements ActionListener{

	private Frame frame;
	
	public Presenter() {
		frame = new Frame(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Start":
			frame.initTrianglePanel();
			break;
		}
		
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
