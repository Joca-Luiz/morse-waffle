package br.com.jocaluiz.morsewaffle;

import java.io.IOException;

import javax.swing.JTextArea;

public class WaffleCommands {
	public static String newline = "\n", help = " If you have any questions about the waffle type the command 'help'";
	
	public void help(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);

		if (prefixCheck) {
			output.setText(
					"Welcome to Morse Waffle a personal task automator. Available Commands:" + newline +
					"01 - echo <string>: write on the board;" + newline +
					"02 - cls: clear the board;" + newline +
					"03 - browser: open your default browser;" + newline +
					"04 - morse <parameter> <string>: use the -t parameter to decode a string, and -c to encode a string. Function in tests can occur errors!" + newline +
					"05 - fullnum <integer>: Use to enter a full number between 0 and 9999999999" + newline +
					"06 - mensager <port> <user>: Use to connect to a port and send and receive messages through that port. ';exit' to clear the port and exit message mode" + newline +
					newline + "New commands added as needed..." + newline +
					"Made by Joca | Powered by java" + newline
			);
		}
	}
	
	public void echo(String prefix, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		String waffle = "Morse Waffle/Echo> ";

		if (prefixCheck) {
			String echoOutput = input.replace(prefix, "") + newline;
			output.append(waffle + echoOutput);
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
		String waffle = "Morse Waffle/Browser> ";

		if (prefixCheck) {
			output.append(waffle + "Opennig Browser... " + newline);
			try {
				Runtime.getRuntime().exec("explorer http://google.com"); 
			} catch (IOException e) {
				output.append(waffle +  "Failed to opening your browser!" + help + newline);
				e.printStackTrace();
			}
		}
	}
	
	public static void clear(JTextArea output) {
		output.setText(null);
	}
	
}