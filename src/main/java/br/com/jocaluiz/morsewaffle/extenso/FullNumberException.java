package br.com.jocaluiz.morsewaffle.extenso;

public class FullNumberException extends Exception {

    public FullNumberException(int numero) {
        super(String.format("Erro ao por em extenso (%s).", numero));
    }

    public FullNumberException(char numero) {
        super(String.format("Erro ao por em extenso (%s).", Character.toString(numero)));
    }
}
