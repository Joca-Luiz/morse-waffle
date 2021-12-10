package br.com.jocaluiz.morsewaffle.extenso;

import javax.swing.JTextArea;

public class Extenso {
    public static String waffle = "Morse Waffle/Number/full> ", newline = "\n",  help = " If you have any questions about the waffle type the command 'help'";

    public static void fullNumber(String prefix, String input, JTextArea output) {
        boolean prefixCheck = input.startsWith(prefix);

        if (prefixCheck) {
            String numero = input.replace(prefix, "");

            if (numero.replaceAll("[0-9]", "").length() == 0) {
                if (numero.length() > 10) {
                    output.append(waffle + "Please use a number between 0 and 9999999999" + newline);
                } else {
                    output.append(waffle + NumeroPorExtenso.get(Integer.parseInt(numero)) + newline);
                }
            } else {
                output.append(waffle + "Please use integer only!" + help + newline);
            }
        }
    }
}
