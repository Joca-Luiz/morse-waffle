package br.com.jocaluiz.morsewaffle.morse;

import javax.swing.JTextArea;

public class Morse {
    public static String waffle = "Morse Waffle/Morse> ", newline = "\n", help = " If you have any questions about the waffle type the command 'help'";

    public static void morse(String prefix, String[] p, String input, JTextArea outputs) {
        boolean prefixCheck = input.startsWith(prefix);

        if(prefixCheck) {
            String parameter = input.replace(prefix, "");

            /* Translate command - default parameter: "-t " */
            if (parameter.startsWith(p[0])) {
                String morse = parameter.replace(p[0], "");

                if (morse.length() > 0) {
                    String translate;
                    try {
                        translate = MorseCode.decodificar(morse);
                        outputs.append(waffle + translate + newline);
                    } catch (MorseCodeException e) {
                        outputs.append(waffle + " Failed to translate, please check your entry!" + help + newline);
                    }
                } else {
                    outputs.append(waffle + "Please write your entry for translation." + help + newline);
                }
            }

            /* Code command - default parameter: "-c " */
            else if (parameter.startsWith(p[1])) {
                String str = parameter.replace(p[1], "");

                if (str.length() > 0) {
                    String code;
                    try {
                        code = MorseCode.codificar(str);
                        outputs.append(waffle + code + newline);
                    } catch (MorseCodeException e) {
                        outputs.append(waffle + "Failed to code, please check your entry!" + help + newline);
                    }
                } else {
                    outputs.append(waffle + "Please write your entry for code." + help + newline);
                }
            }

            else {
                outputs.append(waffle + "the parameter wasn't identified!" + help + newline);
            }
        }
    }
}
