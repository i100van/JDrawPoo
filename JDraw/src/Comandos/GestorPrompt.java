package Comandos;

import Excepciones.ComandoNoValidoPorForma;
import Excepciones.NumeroDeArgumentosIncorrecto;
import Figuras.Figura;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorPrompt {

    private final String[] COMANDOS = {"line", "circle", "pencolor", "fillcolor", "width", "rect", "text", "ellipse", "clear", "undo", "save", "load"};
    private final int[] ARGUMENTOS = {4, 3, 4, 4, 1, 4, 3, 4, 0, 0, 2, 2};

    private String comando;
    private ArrayList argumentos;
    private String text;
    private ArrayList<Figura> historial;

    public GestorPrompt() {
        this.comando = null;
        this.argumentos = null;
        this.historial = new ArrayList<>();
    }

    public void pedir_comando() {
        ArrayList<Integer> argument = new ArrayList<>();
        boolean Error = true;
        int erroresCometidos = 0;
        Scanner scan = new Scanner(System.in);
        String mandato = null;
        String linea = null;
        while (Error) {//TODO remodelar esto con una matriz de copmandos y su numero de parametros para comprobar que la entrada es correcta
            System.out.print("JDraw ~$: ");
            Error = false;
            try {
                linea = scan.nextLine();
                //Comprobar la forma
                if (linea.split(" ").length == 2) {
                    mandato = linea.split(" ")[0];
                    String[] args = linea.split(" ")[1].split(",");
                    //Comprobar el comando y el numero de argumentos
                    for (int i = 0; i < COMANDOS.length - 1; i++) {
                        if (mandato.equals(COMANDOS[i])) {
                            if (args.length == ARGUMENTOS[i]) {
                                //Si es comando text el ultimo parametro debe ser un string
                                if (!mandato.equals("text")) {
                                    for (int j = 0; j < (args.length); j++) {
                                        argument.add(Integer.parseInt(args[j]));
                                    }
                                } else {
                                    for (int j = 0; j < (args.length) - 1; j++) {
                                        argument.add(Integer.parseInt(args[j]));
                                    }
                                    this.text = args[2];
                                }
                                break;
                            } else throw new NumeroDeArgumentosIncorrecto();
                        }
                    }
                } else throw new ComandoNoValidoPorForma();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Error = true;
            }
            //Mostrar la ayuda en caso de 3 errores
            erroresCometidos++;
            if (erroresCometidos % 3 == 0) {
                Help ayuda = new Help();
                ayuda.showhelp();
            }
        }
        System.out.println("No ha habido error en formato. Comando:" + mandato + " ,Args[]:" + argument.toString());
        this.comando = mandato;
        this.argumentos = argument;
    }

    public void add_Historial(Figura fi) {
        this.historial.add(fi);
    }

    public String getComando() {
        return comando;
    }

    public ArrayList<Figura> getHistorial() {
        return historial;
    }

    public ArrayList<Integer> getArgumentos() {
        return argumentos;
    }

    public String getText() {
        return text;
    }
}
