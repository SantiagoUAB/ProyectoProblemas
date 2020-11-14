package ProyectoProblemas;

import java.awt.Graphics;

import javax.swing.JFrame;

import ProyectoProblemas.Controller.InputListener;

public class ViewMock extends JFrame implements ViewInterface {
	
	public ViewMock() {
	}

	public void setKeyListener(InputListener inputListener) {
		addKeyListener(inputListener);
	}
}
