package Excepciones;

public class ComandoNoValidoEnFormato extends Exception {
    public ComandoNoValidoEnFormato() {
        super("Comando no valido, introduzca parametros adecuados");
    }
}
