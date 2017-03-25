package example.paint;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class Circle extends Frame{

	@Override
	public void print(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(50, 50, 30, 30);
	}
	
	public void lanchFrame(){
		setBounds(400,400,300,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
			new Circle().lanchFrame();

	}

}
