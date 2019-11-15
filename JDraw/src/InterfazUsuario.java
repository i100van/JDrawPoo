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
        this.modificador=new Modificador();
        file.vaciar_documento();
        boolean fin = false;
        while (!fin) {
            try {
                file.escribir_historial(prompt.getHistorial());
                prompt.pedir_comando();
                ArrayList<String> textos = prompt.getText();
                ArrayList<Integer> argumentos = prompt.getArgumentos();
                switch (prompt.getComando()) {
                    case "line":
                        Linea linea = new Linea(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(linea));
                        break;
                    case "rect":
                        Rectangulo rectangulo = new Rectangulo(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(rectangulo));
                        break;
                    case "circle":
                        Circulo circulo = new Circulo(argumentos.get(0), argumentos.get(1), argumentos.get(2));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(circulo));
                        break;
                    case "text":
                        Texto texto = new Texto(argumentos.get(0), argumentos.get(1), textos.get(0));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(texto));
                        break;
                    case "ellipse":
                        Elipse elipse = new Elipse(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(elipse));
                        break;
                    case "pencolor":
                        int[] par_borde = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};
                        modificador.setParBorde(par_borde);
                        break;
                    case "fillcolor":
                        int[] par_color = {argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3)};
                        modificador.setParColor(par_color);
                        break;
                    case "width":
                        modificador.setAncho(argumentos.get(0));
                        break;
                    case "clear":
                        //TODO: Hay problemas de funcionamiento, preguntar como vaciar
                        this.file.vaciar_documento();
                        break;
                    case "undo":
                        this.prompt.undo();
                        break;
                    case "save":
                        //TODO: Hacer save
                        System.out.println("Estoy en save con parametros:"+comando+textos);
                        break;
                    case "load":
                        //TODO: Hacer load
                        System.out.println("Estoy en load");
                        break;
                    case "exit":
                        fin = true;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}




