import Comandos.GestorPrompt;
import Excepciones.NumeroDeArgumentosIncorrecto;
import Ficheros.Fichero;
import Figuras.*;

import java.io.IOException;
import java.util.ArrayList;

public class InterfazUsuario {
    private GestorPrompt prompt;
    private Fichero file;
    public InterfazUsuario() throws NumeroDeArgumentosIncorrecto, IOException {
        boolean fin = false;
        this.prompt = new GestorPrompt();
        this.file = new Fichero();
        while (!fin) {
            prompt.pedir_comando();
            System.out.println(prompt.getHistorial().toString());
            String comando = prompt.getComando();
            ArrayList<Integer> argumentos = prompt.getArgumentos();
            switch (comando) {
                case "line":
                    Linea linea = new Linea(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    file.escribir_figura(linea.toString());
                    break;
                case "rect":
                    Rectangulo rectangulo = new Rectangulo(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    break;
                case "circle":
                    Circulo circulo = new Circulo(argumentos.get(0), argumentos.get(1), argumentos.get(2));
                    file.escribir_figura(circulo.toString());
                    break;
                case "text":
                    Texto texto = new Texto(argumentos.get(0), argumentos.get(1), prompt.getText());
                    file.escribir_figura(texto.toString());
                    break;
                case "ellipse":
                    Elipse elipse = new Elipse(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    file.escribir_figura(elipse.toString());
                    break;
                case "pencolor":
                    System.out.println("Estoy en pencolor");
                    break;
                case "fillcolor":
                    System.out.println("Estoy en fillcolor");
                    break;
                case "width":
                    System.out.println("Estoy en width");
                    break;
                case "clear":
                    System.out.println("Estoy en clear");
                    this.file=new Fichero();
                    break;
                case "undo":
                    System.out.println("Estoy en undo");
                    break;
                case "save":
                    System.out.println("Estoy en save");
                    break;
                case "load":
                    System.out.println("Estoy en load");
                    break;
                case "exit":
                    System.out.println("Estoy en exit");
                    fin = true;

            }
            file.cerrar_fichero();
        }

    }
}
