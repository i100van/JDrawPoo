package Excepciones;

public class ComandoNoValidoPorForma extends Exception {
    public ComandoNoValidoPorForma() {
        super("Comando no valido, debe tener extructura mandato var,var..");
    }
}
