package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    @Test
    void deveEnviarUmaMensagem() {
        Pessoa ana = new Pessoa("Ana");
        Mensagem mensagemParaRafael = new Mensagem("Mensagem escrita",  "Rafael");
        ana.escrever(mensagemParaRafael);
        mensagemParaRafael.enviar();
        assertEquals("Ana enviou a Mensagem{conteudo='Mensagem escrita', destinatario='Rafael'}", ana.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagens() {
        Pessoa ana = new Pessoa("Ana");
        Pessoa joao = new Pessoa("João");
        Mensagem mensagemParaRafael = new Mensagem("Mensagem escrita", "Rafael");
        ana.escrever(mensagemParaRafael);
        joao.escrever(mensagemParaRafael);
        mensagemParaRafael.enviar();
        assertEquals("Ana enviou a Mensagem{conteudo='Mensagem escrita', destinatario='Rafael'}", ana.getUltimaMensagem());
        assertEquals("João enviou a Mensagem{conteudo='Mensagem escrita', destinatario='Rafael'}", joao.getUltimaMensagem());
    }

    @Test
    void naoDeveEnviarMensagem() {
        Pessoa ana = new Pessoa("Ana");
        Mensagem mensagemParaRafael = new Mensagem("Mensagem escrita", "Rafael");
        mensagemParaRafael.enviar();
        assertEquals(null, ana.getUltimaMensagem());
    }

    @Test
    void deveEnviarSomenteMensagemDaAna() {
        Pessoa ana = new Pessoa("Ana");
        Pessoa joao = new Pessoa("João");
        Mensagem mensagemParaRafael = new Mensagem("Mensagem escrita", "Rafael");
        Mensagem mensagemParaSandra = new Mensagem("Mensagem escrita", "Sandra");
        ana.escrever(mensagemParaRafael);
        mensagemParaRafael.enviar();
        joao.escrever(mensagemParaSandra);
        assertEquals("Ana enviou a Mensagem{conteudo='Mensagem escrita', destinatario='Rafael'}", ana.getUltimaMensagem());
        assertEquals(null, joao.getUltimaMensagem());
    }
}