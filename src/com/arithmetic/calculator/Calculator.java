package com.arithmetic.calculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.util.*;

// this is just a test
public class Calculator extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static float addTemp 	= 0;
	private static float subTemp 	= 0;
	private static float mulTemp 	= 0;
	private static float divTemp 	= 0;
	private static int operation	 	= 0;
	private static boolean isSet 	= false;
	JTextField txtDisplay					= new JTextField(16);
	ArrayList<String> buttonNames = new ArrayList<String>( Arrays.asList( "1","2","3","+","4","5","6","- ","7","8","9","/ ",".","0","=","* " )  );

	public Calculator() {
		
		add(txtDisplay);
		for( String  buttonName : buttonNames ) {
			
			JButton btnNumber = new JButton(buttonName)	;
			add(btnNumber);
			btnNumber.addActionListener(this);
			btnNumber.setName(buttonName);
		}
		
		setLayout(new FlowLayout());
		
		//setting defaults		
		txtDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtDisplay.setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(210, 180);
		setTitle("Arith Processor");
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton objBtnText = (JButton) event.getSource();
//		setButtonFunctions(objBtnText.getName());
		System.out.println(objBtnText);
	}
	
	public void setButtonFunctions( String buttonText ) {
		
		switch (buttonText){
			case "1":
				addStringToDisplay("1");
				break;
			case "2":
				addStringToDisplay("2");
				break;
			case "3":
				addStringToDisplay("3");
				break;
			case "4":
				addStringToDisplay("4");
				break;
			case "5":
				addStringToDisplay("5");
				break;
			case "6":
				addStringToDisplay("6");
				break;
			case "7":
				addStringToDisplay("7");
				break;
			case "8":
				addStringToDisplay("8");
				break;
			case "9":
				addStringToDisplay("9");
				break;
			case "0":
				addStringToDisplay("0");
				break;
			case "+":
				addition();
				break;
			case "- ":
				subtraction();
				break;
			case "* ":
				multiplication();
				break;
			case "/ ":
				division();
				break;
			case "=":
				equals();
				break;
			case ".":
				addDecimal();
				break;
		}
	}
	
	public void addStringToDisplay( String displayString) {
		
		String getDisplayString = txtDisplay.getText();
		
		if( (addTemp != 0 || subTemp != 0 || mulTemp != 0 ||divTemp != 0) && (isSet == true ) ) {
			getDisplayString= "";
		}
		
		if( displayString .equals("0")  && ( getDisplayString .equals("0") || getDisplayString.equals(null) ) ) {
			txtDisplay.setText("0");
		} else if( getDisplayString .equals("0") ){
			getDisplayString = "";
			txtDisplay.setText(getDisplayString+displayString);
		} else{
			txtDisplay.setText(getDisplayString+displayString);
		}
		isSet = false;
	}
	
	public void addition() {
		
		float getDisplayNumber = Float.parseFloat(txtDisplay.getText());
		operation =1;
		if( addTemp==0) {
			addTemp = getDisplayNumber;
		} else {
			equals();
			addTemp = Float.parseFloat(txtDisplay.getText());
		}
		subTemp =0;
		mulTemp=0;
		divTemp=0;
		isSet = true;
	}
	
	public void subtraction() {

		float getDisplayNumber = Float.parseFloat(txtDisplay.getText());
		operation =2;
		if( subTemp==0) {
			subTemp = getDisplayNumber;
		} else {
			equals();
			subTemp = Float.parseFloat(txtDisplay.getText());
		}
		addTemp = 0;
		mulTemp=0;
		divTemp=0;
		isSet = true;
	}
	
	public void multiplication() {
		
		float getDisplayNumber = Float.parseFloat(txtDisplay.getText());
		operation =3;
		if( mulTemp==0) {
			mulTemp = getDisplayNumber;
		} else {
			equals();
			mulTemp = Float.parseFloat(txtDisplay.getText());
		}
		addTemp = 0;
		subTemp=0;
		divTemp=0;
		isSet = true;
	}
	
	public void division() {
		float getDisplayNumber = Float.parseFloat(txtDisplay.getText());
		operation =4;
		if( divTemp==0) {
			divTemp = getDisplayNumber;
		} else {
			equals();
			divTemp = Float.parseFloat(txtDisplay.getText());
		}
		addTemp = 0;
		subTemp=0;
		mulTemp=0;
		isSet = true;
	}
	
	public void addDecimal() {
		String getDisplayNumber = txtDisplay.getText();
		if( false == getDisplayNumber.contains(".") ) {
			addStringToDisplay(".");
		} 
	}
	
	public void equals() {
		
		float getDisplayNumberasFloat = Float.parseFloat(txtDisplay.getText());
		switch(operation) {
			case 1:
				txtDisplay.setText(Float.toString(addTemp+getDisplayNumberasFloat));
				addTemp = 0;
				break;
			case 2:
				txtDisplay.setText(Float.toString(subTemp-getDisplayNumberasFloat));
				subTemp =0;
				break;
			case 3:
				txtDisplay.setText(Float.toString(mulTemp*getDisplayNumberasFloat));
				mulTemp = 0;
				break;
			case 4:
				if( getDisplayNumberasFloat == 0) {
					txtDisplay.setText("Asshole, its divide by zero error");
					divTemp =0;
					break;
				}
				txtDisplay.setText(Float.toString(divTemp/getDisplayNumberasFloat));
				divTemp =0;
				break;
				
				
				
		}
	}

	public void checkNumber( String strTxt ) {
		
		System.out.println(Integer.parseInt(strTxt));
	
	}
}
