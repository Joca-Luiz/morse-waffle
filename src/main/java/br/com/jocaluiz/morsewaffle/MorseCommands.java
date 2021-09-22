package br.com.jocaluiz.morsewaffle;

import java.io.IOException;

import javax.swing.JTextArea;

public class MorseCommands {
	public static String newline = "\n";
	
	public void help(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			output.setText(
					"Welcome to Morse Waffle a personal task automator. Available Commands:" + newline +
					"01 - echo <string>: write on the board;" + newline +
					newline + "New commands added as needed..." + newline +
					"Made by Joca | Powered by java" + newline
			);
		}
	}
	
	public void echo(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			String echoOutput = input.replace(prefix, "") + newline;
			output.append(echoOutput);
		}
	}
	
	public void clearCommand(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			clear(output);
		}
	}
	
	public void browser(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			output.append("Opennig Browser... " + newline);
			try {
				Runtime.getRuntime().exec("explorer http://google.com"); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void clear(JTextArea output) {
		output.setText(null);
	}
	
}