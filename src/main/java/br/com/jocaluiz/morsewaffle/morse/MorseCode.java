package br.com.jocaluiz.morsewaffle.morse;

import java.util.Arrays;
import java.util.List;

public class MorseCode {

    private static final List ALFABETO = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ',', '.', '?',
            '\'', '!', '/', '(', ')', '&', ':', ';', '=', '-', '_', '"', '$',
            '@', ' ');
    private static final List MORSE = Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..",
            "----.", "-----", "--..--", ".-.-.-", "..--..", "·----·", "-·-·--",
            "-··-·", "-·--·", "-·--·-", "·-···", "---···", "-·-·-·", "-···-",
            "-····-", "··--·-", "·-··-·", "···-··-", "·--·-·", "");

    /**
     * Codifica uma mensagem para o padrão Código Morse.
     *
     * @param mensagem Menagem que se quer codificar.
     *
     * @return Código Morse pronto para transmissão.
     *
     * @throws br.com.jocaluiz.morsewaffle.morse.MorseCodeException
     */
    public static String codificar(String mensagem) throws MorseCodeException {
        String codigoMorse = "";
        String mensagemTrabalho = mensagem.toLowerCase();

        for (int c = 0; c < mensagemTrabalho.length(); c++) {
            if (ALFABETO.contains(mensagemTrabalho.charAt(c))) {
                if (!codigoMorse.isEmpty()) {
                    codigoMorse += " ";
                }
                codigoMorse += MORSE.get(ALFABETO.indexOf(mensagemTrabalho.charAt(c)));
            } else {
                throw new MorseCodeException(mensagemTrabalho.charAt(c));
            }
        }

        return codigoMorse;
    }

    /**
     * Traduz uma mensagem codificada em Código Morse.
     *
     * @param codigoMorse Mensagem codificada em Código Morse.
     *
     * @return Mensagem decodificada.
     *
     * @throws br.com.jocaluiz.morsewaffle.morse.MorseCodeException
     */
    public static String decodificar(String codigoMorse) throws MorseCodeException {
        String mensagem = "";

        for (String sinal : codigoMorse.split(" ")) {
            if (MORSE.contains(sinal)) {
                mensagem += ALFABETO.get(MORSE.indexOf(sinal));
            } else {
                throw new MorseCodeException(sinal);
            }
        }

        return mensagem;
    }
}
