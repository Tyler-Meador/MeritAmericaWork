import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.*;


public class BoxDiagram extends GraphicsProgram{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	private HashMap<String, GObject> boxes;
	private GObject clickObject;
	private GPoint click;
	private JTextField textField;
	private JLabel addLabel;
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;
	

	
	public void init() {
		
		boxes = new HashMap<String, GObject>();
		
		createButtons();
		

		addActionListeners();
		addMouseListeners();
		
	}
	
	public void createButtons() {
		textField = new JTextField(40);
		textField.addActionListener(this);
		addLabel = new JLabel("Name");
		addButton = new JButton("add");
		removeButton = new JButton("remove");
		clearButton = new JButton("clear");
		
		add(addLabel, SOUTH);
		add(textField, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addButton) {
			String name = textField.getText();
			GCompound labelBox = new GCompound();
			GRect box = new GRect(BOX_WIDTH, BOX_HEIGHT);
			GLabel label = new GLabel(name);
			labelBox.add(box, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
			labelBox.add(label, -label.getWidth() / 2, label.getAscent() / 2);
			
			
			add(labelBox, getWidth() / 2, getHeight() / 2);
			boxes.put(name, labelBox);
		}
		else if(e.getSource() == removeButton) {
			String removeBox = textField.getText();
			GObject deadBox = boxes.get(removeBox);
			
			
			if(deadBox !=null) {
				remove(deadBox);
			}
		}
		
		else if(e.getSource() == clearButton) {
			Iterator<String> iterator = boxes.keySet().iterator();
			while(iterator.hasNext()) {
				String name = iterator.next();
				GObject deadBox = boxes.get(name);
				if(deadBox != null) {
					remove(deadBox);
				}
				
			}
			boxes.clear();
		}
		
		
	}
	

	
	
	public void mousePressed(MouseEvent e) {
		click = new GPoint(e.getPoint());
		clickObject = getElementAt(click);
	}
	
	public void mouseDragged(MouseEvent e) {
		if(clickObject != null) {
			clickObject.move(e.getX() - click.getX(), e.getY() - click.getY());
			
			click = new GPoint(e.getPoint());
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(clickObject != null) {
			clickObject.sendToFront();
		}
	}
	
	
	
}
