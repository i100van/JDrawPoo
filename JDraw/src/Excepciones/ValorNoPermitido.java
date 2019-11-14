package Excepciones;

public class ValorNoPermitido extends Exception {
    public ValorNoPermitido() {
        super("El valor introducido no es valido");
    }
}
