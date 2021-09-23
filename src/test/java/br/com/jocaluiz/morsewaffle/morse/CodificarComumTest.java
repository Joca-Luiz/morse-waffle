package br.com.jocaluiz.morsewaffle.morse;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CodificarComumTest {

    @Test
    public void testSomeMethod() throws MorseCodeException {
        String mensagem = "";
        boolean obtido = MorseCode.codificar(mensagem).isEmpty();
        String mensagemErro = "Uma mensagem vazia deve retornar um código morse igualmente vazio.";

        Assertions.assertTrue(obtido, mensagemErro);
    }

    @Test
    public void testHelloWorld() throws MorseCodeException {
        String mensagem = "Hello world.";
        String esperado = ".... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-.-.-";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    @Test
    public void testCodigoMorse() throws MorseCodeException {
        String mensagem = "Codigo Morse";
        String esperado = "-.-. --- -.. .. --. ---  -- --- .-. ... .";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    @Test
    public void testHeyJude() throws MorseCodeException {
        String mensagem = "Hey Jude";
        String esperado = ".... . -.--  .--- ..- -.. .";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    @Test
    public void testCaractereInvalido() throws MorseCodeException {
        assertThrows(MorseCodeException.class, new Executable() {
                 @Override
                 public void execute() throws Throwable {
                     MorseCode.codificar("á");
                 }
             });
    }
}
