package observer;

import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {
    private String nome;
    private String ultimaMensagem;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getUltimaMensagem() {
        return this.ultimaMensagem;
    }

    public void escrever(Mensagem mensagem) {
        mensagem.addObserver(this);
    }

    public void update(Observable mensagem, Object arg) {
        this.ultimaMensagem = this.nome + " enviou a " + mensagem.toString();
    }
}
