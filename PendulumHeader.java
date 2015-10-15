package pendulumapp;

import java.awt.*;
import javax.swing.*;

public class PendulumHeader extends JPanel {
	JLabel label;

	public PendulumHeader() {
		super();
		
		this.setBackground(Color.red);
		label = new JLabel ("Pendulum");
		label.setForeground(Color.white);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// TBD: label.setBorder(...);
		this.setLayout(new GridLayout(1, 1));
		this.add(label);
	}
	
}
