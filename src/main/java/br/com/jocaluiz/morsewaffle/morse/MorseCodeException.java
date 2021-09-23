package br.com.jocaluiz.morsewaffle.morse;

public class MorseCodeException extends Exception {

    public MorseCodeException(String caractere) {
        super(String.format("Caractere inválido (%s).", caractere));
    }

    public MorseCodeException(char caractere) {
        super(String.format("Caractere inválido (%s).", Character.toString(caractere)));
    }
}
