import Comandos.GestorPrompt;
import Comandos.Modificador;
import Excepciones.ArgumentosNoValidos;
import Ficheros.Fichero;
import Figuras.*;

import java.io.IOException;
import java.util.ArrayList;

public class InterfazUsuario {
    private GestorPrompt prompt;
    private Fichero file;
    private Modificador mBorde;
    private Modificador mColor;

    public InterfazUsuario() throws IOException, ArgumentosNoValidos {
        this.prompt = new GestorPrompt();
        this.file = new Fichero();
        boolean fin = false;
        while (!fin) {
            prompt.pedir_comando();
            System.out.println("El historial de mandatos correctos es: " + prompt.getHistorial().toString());
            String comando = prompt.getComando();
            ArrayList<Integer> argumentos = prompt.getArgumentos();
            switch (comando) {
                case "line":
                    Linea linea = new Linea(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    this.prompt.add_Historial(linea);
                    break;
                case "rect":
                    Rectangulo rectangulo = new Rectangulo(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    break;
                case "circle":
                    Circulo circulo = new Circulo(argumentos.get(0), argumentos.get(1), argumentos.get(2));
                    break;
                case "text":
                    Texto texto = new Texto(argumentos.get(0), argumentos.get(1), prompt.getText());
                    break;
                case "ellipse":
                    Elipse elipse = new Elipse(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                    break;
                case "pencolor":
                    System.out.println("Estoy en pencolor");
                    int[] par_borde = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};
                    this.mColor = new Modificador(par_borde);
                    break;
                case "fillcolor":
                    System.out.println("Estoy en fillcolor");
                    int[] par_color = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};
                    this.mBorde = new Modificador(par_color);
                    break;
                case "width":
                    System.out.println("Estoy en width");
                    break;
                case "clear":
                    System.out.println("Estoy en clear");
                    this.file = new Fichero();
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




