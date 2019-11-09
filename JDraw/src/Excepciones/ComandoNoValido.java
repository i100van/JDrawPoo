package Excepciones;

public class ComandoNoValido extends Exception {
    public ComandoNoValido() {
        super("Comando no valido, debe tener extructura mandato var,var..");
    }
}
