package co.edu.uptc.view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Frame extends JFrame{

	private MenuPanel menuPanel;
	
	public Frame(ActionListener actionListener) {
		super("Sierpinski Triangle");
		this.setSize(900,620);
		this.initComponents(actionListener);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		menuPanel = new MenuPanel(actionListener);
		add(menuPanel);
	}
	
	public void initTrianglePanel() {
		menuPanel.initTrianglePanel();
	}
}
