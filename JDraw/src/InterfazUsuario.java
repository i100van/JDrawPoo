import Comandos.GestorPrompt;
import Excepciones.NumeroDeArgumentosIncorrecto;
import Ficheros.Fichero;
import Figuras.Linea;
import Figuras.Texto;

import java.io.IOException;
import java.util.ArrayList;

public class InterfazUsuario {
    public InterfazUsuario() throws NumeroDeArgumentosIncorrecto, IOException {
        boolean fin = false;
        GestorPrompt prompt = new GestorPrompt();
        Fichero file = new Fichero();
        //file.escribir_figura();
        while (!fin) {
            prompt.pedir_comando();
            System.out.println(prompt.getHistorial().toString());
            String comando = prompt.getComando();
            ArrayList<Integer> argumentos = prompt.getArgumentos();
            switch (comando) {
                case "line":
                    System.out.println("Estoy dibujando linea");
                    Linea linea = new Linea(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    int borde[] = {1, 2, 3, 4};
                    linea.setBorde(borde);
                    System.out.println(linea.toString());
                    break;
                case "rect":
                    System.out.println("Estoy dibujando rectangulo");
                    break;
                case "circle":
                    System.out.println("Estoy dibujando circulo");
                    break;
                case "text":
                    System.out.println("Estoy dibujando texto");
                    Texto texto = new Texto(argumentos.get(0), argumentos.get(1), prompt.getText());
                    System.out.println(texto.toString());
                    break;
                case "ellipse":
                    System.out.println("Estoy dibujando elipse");
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

        }

    }
}
