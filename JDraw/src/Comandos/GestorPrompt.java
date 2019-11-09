package Comandos;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorPrompt {

    private final String[] COMANDOS = {"line", "circle", "pencolor", "fillcolor", "width", "rect", "text", "ellipse", "clear", "undo", "save", "load"};
    private final int[] ARGUMENTOS = {4,3,4,4,1,4,3,4,0,0,2,2};

    private String comando;
    private ArrayList<Integer> argumentos;
    private String text;
    private ArrayList<String> historial;

    public GestorPrompt() {
        this.comando = null;
        this.argumentos = null;
        this.historial = new ArrayList<>();
    }

    public void pedir_comando() {
        ArrayList<Integer> argument = new ArrayList<>();
        boolean Error = true;
        String mandato = null;
        String linea = null;
        int erroresCometidos = 0;
        Scanner scan = new Scanner(System.in);
        while (Error){//TODO remodelar esto con una matriz de copmandos y su numero de parametros para comprobar que la entrada es correcta
            System.out.print("JDraw ~$: ");
            try {
                linea = scan.nextLine();
                //Comprobar la longitud y guardar los argumentos
                if (linea.split(" ").length == 2) {
                    mandato = linea.split(" ")[0];
                    String[] args = linea.split(" ")[1].split(",");
                    if (mandato.equals("text") && args.length==3) {
                        for (int i = 0; i < (args.length) - 1; i++) {
                            argument.add(Integer.parseInt(args[i]));
                        }
                        this.text = args[args.length-1];
                    } else {
                        for (int i = 0; i < (args.length); i++) {
                            argument.add(Integer.parseInt(args[i]));
                        }
                    }
                    //Comprobar el comando
                    for (int i = 0; i < COMANDOS.length - 1; i++) {
                        if (mandato.equals(COMANDOS[i])) {
                            Error = false;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            erroresCometidos++;
            if (erroresCometidos % 3 == 0) {
                Help ayuda = new Help();
                ayuda.showhelp();
            }
        }
        System.out.println("NO ha habido error");
        this.comando = mandato;
        this.argumentos = argument;
        this.historial.add(linea);
    }

    public String getComando() {
        return comando;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

    public ArrayList<Integer> getArgumentos() {
        return argumentos;
    }

    public String getText() {
        return text;
    }
}
