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
					"02 - clear: clear the board; " + newline +
					"03 - browser: open your deufalt browser;" + newline +
					"04 - morse <parameter> <string>: use parameter -t to translate the string or -c to code your string;" + newline +
					newline + "New commands added as needed..." + newline +
					"Made by Joca | Powered by java" + newline
			);
		}
	}
	
	public void echo(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			String echoOutput = input.replace(prefix, "") + newline;
			output.append("Morse Waffle/Echo> " + echoOutput);
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
			output.append("Morse Waffle/Browser> Opennig Browser... " + newline);
			try {
				Runtime.getRuntime().exec("explorer http://google.com"); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void morse(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		if (prefixCheck) {
			String parameter = input.replace(prefix, "");
			
			/* Translate String */
			if (parameter.startsWith("-t ")) {
				String morse = parameter.replace("-t ", "").replaceAll("[a-zA-Z0-9]", "");
				if (morse == "") {
					output.append("Morse Waffle/Morse> Please write some value to translate" + newline);
				} else {
					String translate = Morse.normal(morse);
					output.append("Morse Waffle/Morse> " + translate + newline);
				}
			} 
			
			/* Morse-Code String */
			else if (parameter.startsWith("-c ")) {
				String morse = parameter.replace("-c ", "");
				if (morse == "") {
					output.append("Morse Waffle/Morse> Please write some value to code" + newline);
				} else {
					String translate = Morse.morse(morse);
					output.append("Morse Waffle/Morse> " + translate + newline);
				}
			} 
			
			else {
				output.append("Morse Waffle/Morse> " + "The parameter is incorrect. use the 'help' command for more information." + newline);
			}
		}
	}
	
	public static void clear(JTextArea output) {
		output.setText(null);
	}
	
}