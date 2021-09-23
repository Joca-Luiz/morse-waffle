package br.com.jocaluiz.morsewaffle.morse;

public class CommandLine {

    public static void main(String[] args) throws MorseCodeException {

        if (args.length > 0) {
            for (int n = 0; n < args.length; ++n) {
                String mensagem = args[n];
                String codificada = MorseCode.codificar(mensagem);
                String traduzida = MorseCode.decodificar(codificada);

                System.out.printf("Mensagem original.: [%s]\n", mensagem);
                System.out.printf("Código Morse......: [%s]\n", codificada);
                System.out.printf("Mensagem traduzida: [%s]\n", traduzida);
            }
        } else {
            System.out.println("Exemplo:");
            System.out.println("java -cp morse-waffle-1.0-SNAPSHOT.jar br.com.jocaluiz.morsewaffle.morse.CommandLine \"Frase1\" [\"Frase2\"]");
        }
    }
}
