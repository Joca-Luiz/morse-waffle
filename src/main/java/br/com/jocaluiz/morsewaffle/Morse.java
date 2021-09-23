package br.com.jocaluiz.morsewaffle;

import javax.swing.JTextArea;

public class Morse {
	public static String newline = "\n";
	
	public static void morse(String prefix, String pT, String pC, String input, JTextArea output) {
		boolean prefixCheck = input.startsWith(prefix);
		
		if (prefixCheck) {
			String parameter = input.replace(prefix, "");
			
			if (parameter.startsWith(pT)) {
				String morse = parameter.replace(pT, "").replaceAll("[^/.-]", "");
				if (morse == "") {
					output.append("Morse Waffle/Morse> Please write some value to translate" + newline);
				} else {
					String translate = MorseFunction.normal(morse);
					if (MorseFunction.error) {
						output.append("Morse Waffle/Morse> Unable to translate. Please correct your entry" + newline);
						MorseFunction.error = false;
					} else {
						output.append("Morse Waffle/Morse> " + translate + newline);
					}
				}
			}
			
			else if (parameter.startsWith(pC)) {
				String morse = parameter.replace(pC, "");
				if (morse == "") {
					output.append("Morse Waffle/Morse> Please write some value to code" + newline);
				} else {
					String translate = MorseFunction.morse(morse);
					output.append("Morse Waffle/Morse> " + translate + newline);
				}
			}
			
			else {
				output.append("Morse Waffle/Morse> " + "The parameter is incorrect. use the 'help' command for more information." + newline);
			}
		}
	}
}