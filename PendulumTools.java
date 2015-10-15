package pendulumapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PendulumTools extends JPanel {
	
	PendulumController controller;
	JButton faster;
	JButton slower;
	JButton shorter;
	JButton longer;
	JButton heavier;
	JButton lighter;
	JButton restart;
	JLabel info;

	public PendulumTools() {
		super();
		
		this.setLayout(new GridLayout(1, 1));
		JPanel controls = new JPanel();
		JPanel infoPanel = new JPanel();
		this.add(controls);
		this.add(infoPanel);
		
		controls.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder() ,"Controls"));
		controls.setLayout(new GridLayout(4, 2));
		
		faster = new JButton("Faster"); 
		controls.add(faster);
		
		slower = new JButton("Slower"); 
		controls.add(slower);
		
		shorter = new JButton("Shorter"); 
		controls.add(shorter);
		
		longer = new JButton("Longer"); 
		controls.add(longer);
		
		heavier = new JButton("More Resistance"); 
		controls.add(heavier);
		
		lighter = new JButton("Less Resistance"); 
		controls.add(lighter);		

		restart = new JButton("RESTART");
		controls.add(restart);		

		infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder() ,"Settings"));
		info = new JLabel("");
		infoPanel.add(info);
		
	}

	public void setController(PendulumController controller) {
		this.controller = controller; 
		faster.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.faster(); }});
		slower.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.slower(); }});
		shorter.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.shorter(); }});
		longer.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.longer(); }});
		heavier.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.moreResistance(); }});
		lighter.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.lessResistance(); }});
		restart.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { controller.restart(); }});
	}
	
	public void updateInfo(String info) {
		this.info.setText(info);
	}
}
