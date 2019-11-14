package Excepciones;

public class NoHayFigurasQueDeshacer extends Exception {
    public NoHayFigurasQueDeshacer() {
        super("No se puede deshacer, no hay ordenes previas");
    }
}
