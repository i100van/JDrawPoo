import Comandos.GestorPrompt;
import Excepciones.ArgumentosNoValidos;
import Excepciones.NumeroDeArgumentosIncorrecto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumeroDeArgumentosIncorrecto, IOException {
        try {
            InterfazUsuario sesion = new InterfazUsuario();
        } catch (ArgumentosNoValidos argumentosNoValidos) {
            argumentosNoValidos.printStackTrace();
        }
    }
}
