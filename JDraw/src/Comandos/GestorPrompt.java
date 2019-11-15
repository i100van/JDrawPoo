package Comandos;

import Excepciones.ComandoNoValidoPorForma;
import Excepciones.NoHayFigurasQueDeshacer;
import Excepciones.NumeroDeArgumentosIncorrecto;
import Figuras.Figura;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorPrompt {

    private final String[] COMANDOS = {"line", "circle", "pencolor", "fillcolor", "width", "rect", "text", "ellipse", "save", "load"};
    private final int[] ARGUMENTOS = {4, 3, 4, 4, 1, 4, 3, 4, 2, 2};

    private String comando;
    private ArrayList<Integer> argumentos;
    private ArrayList<String> text;
    private ArrayList<Figura> historial;
    private float op;

    public GestorPrompt() {
        this.comando = null;
        this.argumentos = null;
        this.historial = new ArrayList<>();
        this.text = new ArrayList<>(2);
        this.op = 1;
    }

    public void pedir_comando() {
        ArrayList<Integer> argument = new ArrayList<>();
        boolean Error = true;
        int erroresCometidos = 0;
        Scanner scan = new Scanner(System.in);
        String mandato = null;
        String linea;
        while (Error) {
            System.out.print("JDraw ~$: ");
            Error = false;
            try {
                linea = scan.nextLine();
                //Comprobar la forma
                if (linea.split(" ").length == 2) {
                    mandato = linea.split(" ")[0];
                    String[] args = linea.split(" ")[1].split(",");
                    argumentos_correctos(argument, mandato, args);
                } else if (es_Undo_Clear(linea)) {
                    mandato = linea.split(" ")[0];
                } else throw new ComandoNoValidoPorForma();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                Error = true;
            }
            //Mostrar la ayuda en caso de 3 errores
            erroresCometidos++;
            if (erroresCometidos % 3 == 0) {
                Help ayuda = new Help();
                ayuda.showhelp();
            }
        }
        this.comando = mandato;
        this.argumentos = argument;
    }

    private void argumentos_correctos(ArrayList<Integer> argument, String mandato, String[] args) throws NumeroDeArgumentosIncorrecto {
        for (int i = 0; i < COMANDOS.length - 1; i++) {
            if (mandato.equals(COMANDOS[i])) {
                if (args.length == ARGUMENTOS[i]) {
                    //Si es comando text el ultimo parametro debe ser un string
                    if (mandato.equals("text")) {
                        for (int j = 0; j < (args.length) - 1; j++) {
                            argument.add(Integer.parseInt(args[j]));
                        }
                        text.clear();
                        text.add(0, args[2]);
                    } else if (mandato.equals("save") || mandato.equals("load")) {
                        text.clear();
                        text.add(0, args[0]);
                        text.add(1, args[1]);
                    } else if (mandato.equals("pencolor") || mandato.equals("fillcolor")) {
                        for (int j = 1; j < (args.length) ; j++) {
                            argument.add(Integer.parseInt(args[j]));
                        }
                        op = Float.parseFloat(args[0]);
                    } else {
                        for (String arg : args) {
                            argument.add(Integer.parseInt(arg));
                        }
                    }
                    break;
                } else throw new NumeroDeArgumentosIncorrecto();
            }
        }
    }

    private boolean es_Undo_Clear(String linea) {
        if (linea.split(" ").length == 1) {
            String mandato = linea.split(" ")[0];
            return mandato.equals("clear") || mandato.equals("undo");
        }
        return false;
    }

    public void add_Historial(Figura fi) {
        this.historial.add(fi);
    }

    public float getOpacidad() {
        return op;
    }

    public void undo() {
        try {
            if (historial.size() > 0) {
                historial.remove(historial.size() - 1);
            } else throw new NoHayFigurasQueDeshacer();
        } catch (NoHayFigurasQueDeshacer noHayFigurasQueDeshacer) {
            System.err.println(noHayFigurasQueDeshacer);
        }
    }

    public void clear() {
        try {
            if (historial.size() > 0) {
                historial.clear();
            } else throw new NoHayFigurasQueDeshacer();
        } catch (NoHayFigurasQueDeshacer noHayFigurasQueDeshacer) {
            System.err.println(noHayFigurasQueDeshacer);
        }
    }

    public String getComando() {
        return comando;
    }

    public ArrayList<Figura> getHistorial() {
        return historial;
    }

    public ArrayList getArgumentos() {
        return argumentos;
    }

    public ArrayList<String> getText() {
        return text;
    }
}
