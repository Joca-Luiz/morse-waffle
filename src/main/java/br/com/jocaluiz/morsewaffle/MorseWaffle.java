package br.com.jocaluiz.morsewaffle;

import javax.swing.JFrame;

import java.awt.Dimension;

public class MorseWaffle {
	public static Dimension frameSize = new Dimension(500, 500);
	public static JFrame frame;
	public static void main(String[]args) {
		frame = frame("Morse Waffle", frameSize, true);
		frame.getContentPane().add(mainTextField(5, 415, 475, 30, "Digite seu comando"));
	}

	public static JFrame frame(String frameName, Dimension frameDimension, boolean frameVisible) {
		JFrame f = new JFrame(frameName);
		f.setSize(frameDimension);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(frameVisible);
		return f;
	}

	public static PlaceholderTextField mainTextField(int x, int y, int w, int h, String tPlaceholderText) {
		PlaceholderTextField t = new PlaceholderTextField();
		t.setBounds(x, y, w, h);
		t.setPlaceholder(tPlaceholderText);
		return t;
	}

}