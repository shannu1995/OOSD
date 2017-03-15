package view;


import javax.swing.*;

public class OptionSelction{
	
public static final String SIZE1 = "10x10";
public static final String SIZE2 = "12x12";
public static final String SIZE3 = "15x15";

private String sizeSelected;
private String playerCountSelected;
	
	public JPanel showOptions(JPanel newPanel){
		
		JRadioButton size1 = new JRadioButton(SIZE1, true);
		JRadioButton size2 = new JRadioButton(SIZE2);
		JRadioButton size3 = new JRadioButton(SIZE3);
		
		JRadioButton p1 = new JRadioButton("3", true);
		JRadioButton p2 = new JRadioButton("4");
		JRadioButton p3 = new JRadioButton("5");
		JRadioButton p4 = new JRadioButton("6");
		
		ButtonGroup radioGroup = new ButtonGroup();
		ButtonGroup radioGroup2 = new ButtonGroup();
		
		JLabel selectSize = new JLabel("Please Select the Size of the Grid", JLabel.LEFT);
		
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        
        
        newPanel.add(selectSize);
        
		radioGroup.add(size1);
		radioGroup.add(size2);
		radioGroup.add(size3);
		
		newPanel.add(size1);
		newPanel.add(size2);
		newPanel.add(size3);
		
		JLabel selectPlayers = new JLabel("Please Select the number of players", JLabel.LEFT);
	
        newPanel.add(selectPlayers);
        
        radioGroup2.add(p1);
		radioGroup2.add(p2);
		radioGroup2.add(p3);
		radioGroup2.add(p4);
		
		newPanel.add(p1);
		newPanel.add(p2);
		newPanel.add(p3);
		newPanel.add(p4);
		

	 	JOptionPane.showOptionDialog(null, newPanel,"Please Select your preferred Game Settings",JOptionPane.OK_CANCEL_OPTION, 0, null, null, radioGroup);
	 	
		if(size1.isSelected()){
			setSizeSelected(SIZE1);
		}
		else if(size2.isSelected()){
			setSizeSelected(SIZE2);
		}
		else{
			setSizeSelected(SIZE3);
		}
		
		if(p1.isSelected()){
			setPlayerCountSelected("3");
		}
		else if(p2.isSelected()){
			setPlayerCountSelected("4");
		}
		else if(p3.isSelected()){
			setPlayerCountSelected("5");
		}
		else{
			setPlayerCountSelected("6");
		}
		
	 	return newPanel;
	}

	public String getSizeSelected() {
		return sizeSelected;
	}

	public void setSizeSelected(String sizeSelected) {
		this.sizeSelected = sizeSelected;
	}

	public String getPlayerCountSelected() {
		return playerCountSelected;
	}

	public void setPlayerCountSelected(String playerCountSelected) {
		this.playerCountSelected = playerCountSelected;
	}
}
