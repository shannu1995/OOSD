package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PositionSelection extends Observable{
	private int xPos;
	private int yPos;
	public JFrame selectPosition(JFrame newFrame){
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
		JLabel x = new JLabel("Please select box number from left: ");
		newPanel.add(x);
		JTextField xPosition = new JTextField("1");
	    xPosition.setPreferredSize( new Dimension(100, 20 ) );
	    xPosition.setMaximumSize(xPosition.getPreferredSize());
		newPanel.add(xPosition);
		JLabel y = new JLabel("Please select box number from top: ");
		newPanel.add(y);
		JTextField yPosition = new JTextField("1");
		yPosition.setPreferredSize( new Dimension(100, 20 ) );
	    yPosition.setMaximumSize(yPosition.getPreferredSize());
	    JButton submitButton = new JButton("Submit");
	    
	    submitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String xValue = xPosition.getText();
				String yValue = yPosition.getText();
				System.out.println(xValue + " from left and " + yValue+ " from top");
				setxPos(Integer.parseInt(xValue));
				setyPos(Integer.parseInt(yValue));
				newFrame.dispose();
				setChanged();
				notifyObservers();
			}
	    });
		newPanel.add(yPosition);
		newPanel.add(submitButton);
		newFrame.add(newPanel);
		newFrame.setVisible(true);
		newFrame.setSize(500, 500);
		newFrame.setAlwaysOnTop (true);
		return newFrame;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
