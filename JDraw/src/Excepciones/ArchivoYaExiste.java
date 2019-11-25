package Excepciones;

public class ArchivoYaExiste extends Exception {
    public ArchivoYaExiste() {
        super("La ruta ya contiene un archivo con ese nombre");
    }
}
