package Excepciones;

public class ComandoNoEncontrado extends Exception {
    public ComandoNoEncontrado() {
        super("Comando no admitido");
    }
}
