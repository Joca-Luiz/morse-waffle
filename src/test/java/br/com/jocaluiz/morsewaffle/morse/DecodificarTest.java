package br.com.jocaluiz.morsewaffle.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodificarTest {

    @Test
    public void testHelloWorld() throws MorseCodeException {
        String mensagem = ".... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-.-.-";
        String esperado = "hello world.";
        String obtido = MorseCode.decodificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }
}
