package observer;

import java.util.Observable;

public class Mensagem extends Observable {
    private String conteudo;
    private String destinatario;

    public Mensagem(String conteudo, String destinatario) {
        this.conteudo = conteudo;
        this.destinatario = destinatario;
    }

    public void enviar() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "conteudo='" + conteudo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                '}';
    }
}
