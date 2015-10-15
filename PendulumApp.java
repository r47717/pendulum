package pendulumapp;

import java.awt.*;

import javax.swing.*;

public class PendulumApp extends JFrame {
	
	private PendulumHeader header;
	private PendulumCanvas canvas;
	private PendulumTools tools;
	private PendulumModel model;
	private PendulumController controller;
	

	public PendulumApp() throws HeadlessException {
		super();
		
		this.setTitle("Pendulum");
		this.setLocation(300, 200);
		this.setSize(600, 600);
		this.setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		header = new PendulumHeader();
		canvas = new PendulumCanvas();
		tools = new PendulumTools();

		this.setLayout(new BorderLayout());
		this.add(header, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.add(tools, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setVisible(true);

		model = new PendulumModel(canvas.getWidth(), canvas.getHeight(), tools);
		controller = new PendulumController(model);
		canvas.setModel(model);
		tools.setController(controller);
		
		this.repaint();
	}
	
	public static void main(String args[]) {
		new PendulumApp();
	}
}
