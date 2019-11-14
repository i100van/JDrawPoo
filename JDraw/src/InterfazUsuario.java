import Comandos.GestorPrompt;
import Comandos.Modificador;
import Ficheros.Fichero;
import Figuras.*;

import java.io.IOException;
import java.util.ArrayList;

public class InterfazUsuario {
    private GestorPrompt prompt;
    private Fichero file;
    private Modificador modificador;

    public InterfazUsuario() throws IOException {
        this.prompt = new GestorPrompt();
        this.file = new Fichero();
        file.vaciar_documento();
        boolean fin = false;
        while (!fin) {
            try {
                file.escribir_historial(prompt.getHistorial());
                this.prompt.pedir_comando();
                String comando = prompt.getComando();
                ArrayList<Integer> argumentos = prompt.getArgumentos();
                System.out.println(comando + argumentos);
                switch (comando) {
                    case "line":
                        Linea linea = new Linea(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(linea);
                        break;
                    case "rect":
                        Rectangulo rectangulo = new Rectangulo(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(rectangulo);
                        break;
                    case "circle":
                        Circulo circulo = new Circulo(argumentos.get(0), argumentos.get(1), argumentos.get(2));
                        this.prompt.add_Historial(circulo);
                        break;
                    case "text":
                        Texto texto = new Texto(argumentos.get(0), argumentos.get(1), prompt.getText());
                        this.prompt.add_Historial(texto);
                        break;
                    case "ellipse":
                        Elipse elipse = new Elipse(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(elipse);
                        break;
                    case "pencolor":
                        System.out.println("Estoy en pencolor");
                        // int[] par_borde = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};

                        break;
                    case "fillcolor":
                        System.out.println("Estoy en fillcolor");

                        //int[] par_color = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};

                        break;
                    case "width":
                        System.out.println("Estoy en width");
                        break;
                    case "clear":
                        this.file.vaciar_documento();
                        break;
                    case "undo":
                        this.prompt.undo();
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
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}




