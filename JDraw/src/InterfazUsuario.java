import Comandos.GestorPrompt;
import Comandos.Modificador;
import Figuras.*;

import java.io.IOException;
import java.util.ArrayList;

public class InterfazUsuario {
    private GestorPrompt prompt;
    private OperadorFicheros operadorFicheros;
    private Modificador modificador;

    public InterfazUsuario() throws IOException {
        this.prompt = new GestorPrompt();
        this.operadorFicheros = new OperadorFicheros();
        this.modificador = new Modificador();
        boolean fin = false;
        while (!fin) {
            try {
                operadorFicheros.escribir_historial(prompt.getHistorial());
                prompt.pedir_comando();
                ArrayList<Integer> argumentos = prompt.getArgumentos();
                ArrayList<String> textos = prompt.getText();
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
                        Texto texto = new Texto(argumentos.get(0), argumentos.get(1), prompt.getText().get(0));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(texto));
                        break;
                    case "ellipse":
                        Elipse elipse = new Elipse(argumentos.get(0), argumentos.get(1), argumentos.get(2), argumentos.get(3));
                        this.prompt.add_Historial(modificador.actuar_en_Figura(elipse));
                        break;
                    case "pencolor":
                        int[] par_borde = {argumentos.get(0), argumentos.get(1), argumentos.get(2)};
                        float op_borde = prompt.getOpacidad();
                        modificador.setParBorde(op_borde, par_borde);
                        break;
                    case "fillcolor":
                        int[] par_color = {argumentos.get(0), argumentos.get(1), argumentos.get(2)};
                        float op_color = prompt.getOpacidad();
                        modificador.setParColor(op_color, par_color);
                        break;
                    case "width":
                        modificador.setAncho(argumentos.get(0));
                        break;
                    case "clear":
                        this.prompt.clearHistory();
                        break;
                    case "undo":
                        this.prompt.undo();
                        break;
                    case "save":
                        System.out.println("prompt = " + prompt.toString());
                        System.out.println("prompt 0 = " + textos.toString());
                        operadorFicheros.save(textos.get(0), textos.get(1), prompt.getHistorial());
                        break;
                    case "load":
                        //TODO: Hacer load
                        System.out.println("Estoy en load");
                        System.out.println("prompt = " + prompt.toString());
                        System.out.println("prompt 0 = " + textos.toString());
                        operadorFicheros.load(textos.get(0), textos.get(1));
                        break;
                    case "exit":
                        operadorFicheros.eliminar_documento();
                        fin = true;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}




