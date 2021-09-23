package br.com.jocaluiz.morsewaffle.morse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseCodeProtocoloTest {

    /*
     * Parar (fim da mensagem) Frequentemente escrito como +
     */
    @Test
    public void testAR() throws MorseCodeException {
        String mensagem = "AR";
        String esperado = ".- .-.";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Espere (por 10 segundos) Responde com C (sim). AS2 significa espere 2
     * minutos, AS5 5 minutos, etc. Para pausas de 10 minutos ou mais, use QRX
     * (veja código Q)
     */
    @Test
    public void testAS() throws MorseCodeException {
        String mensagem = "AS";
        String esperado = ".- ...";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Separador dentro da mensagem Frequentemente escrito como =. Na prática,
     * indistinguível para TV, e algumas vezes escrito assim
     */
    @Test
    public void testBT() throws MorseCodeException {
        String mensagem = "BT";
        String esperado = "-... -";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Saindo do ar "Livre"
     */
    @Test
    public void testCL() throws MorseCodeException {
        String mensagem = "CL";
        String esperado = "-.-. .-..";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Troque por código wabun
     */
    @Test
    public void testDO() throws MorseCodeException {
        String mensagem = "DO";
        String esperado = "-.. ---";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Convite geral para transmitir Frequentemente enviado após CQ
     */
    @Test
    public void testK() throws MorseCodeException {
        String mensagem = "K";
        String esperado = "-.-";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Convite específico para transmitir Frequentemente indica "de volta para
     * você"
     */
    @Test
    public void testKN() throws MorseCodeException {
        String mensagem = "KN";
        String esperado = "-.- -.";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Recebido e entendido "Roger"
     */
    @Test
    public void testR() throws MorseCodeException {
        String mensagem = "R";
        String esperado = ".-.";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Fim (fim do contato) Na prática, indistinguível de VA, e algumas vezes escrito assim
     */
    @Test
    public void testSK() throws MorseCodeException {
        String mensagem = "SK";
        String esperado = "... -.-";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "Tradução incorreta.";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }

    /*
     * Mensagem de sério perigo e pedido por ajuda urgente. Não usada ao menos
     * em iminência de perigo para a vida ou para embarcações no mar.
     */
    @Test
    public void testSOS() throws MorseCodeException {
        String mensagem = "SOS";
        String esperado = "... --- ...";
        String obtido = MorseCode.codificar(mensagem);
        String mensagemErro = "A mensagem padrão é SOS e deveria ser traduida para ...---...";

        Assertions.assertEquals(esperado, obtido, mensagemErro);
    }
}
