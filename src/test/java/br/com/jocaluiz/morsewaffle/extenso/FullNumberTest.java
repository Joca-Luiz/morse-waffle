package br.com.jocaluiz.morsewaffle.extenso;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FullNumberTest {

    @Test
    public void intNumberTest() throws FullNumberException {
        int numero = 123;
        String esperado = "cento e vinte e três";
        String obtido = NumeroPorExtenso.get(numero);
        String mensagemErro = "Erro ao por em extenso.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

}