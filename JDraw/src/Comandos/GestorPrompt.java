package Comandos;

import Excepciones.ComandoNoEncontrado;
import Excepciones.ComandoNoValidoEnFormato;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorPrompt {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private final String[] lista_comandos = {"line", "circle", "pencolor", "fillcolor", "width", "rect", "text", "ellipse", "clear", "undo", "save", "load"};
    private String comando;
    private ArrayList<Integer> argumentos;
    private ArrayList<String> historial;


    public GestorPrompt() {
        this.comando=null;
        this.argumentos=null;
        this.historial = new ArrayList<>();
    }

    private void showhelp() {
        System.out.println(ANSI_RED+"Los comandos admitidos son los siguientes");
        System.out.println("line x0,y0,x1,y1");
        System.out.println("fillcolor o,r,g,b");
        System.out.println("pencolor o,r,g,b");
        System.out.println("width n");
        System.out.println("rect x,y,w,h");
        System.out.println("circle x,y,r");
        System.out.println("text x,y,mensaje");
        System.out.println("elipse x,y,rx,ry");
        System.out.println("clear");
        System.out.println("undo");
        System.out.println("save ruta,nombre");
        System.out.println("load ruta,nombre");
        System.out.println("exit 0"+ANSI_RESET);
    }

    public String getComando() {
        return comando;
    }

    public String[] getlista_comandos() {
        return lista_comandos;
    }

    public ArrayList<Integer> getArgumentos() {
        return argumentos;
    }

    public void pedir_comando() {
        ArrayList<Integer> argument = new ArrayList<>();
        boolean Error = true;
        String mandato = null;
        String linea=null;
        int erroresCometidos=0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("JDraw ~$: ");
            try {
                linea = scan.nextLine();
                if (linea.split(" ").length == 2) {
                    mandato = linea.split(" ")[0];
                    String[] args = linea.split(" ")[1].split(",");
                    for (int i = 0; i < (args.length) - 1; i++) {
                        argument.add(Integer.parseInt(args[i]));
                    }
                    //Comprobar el comando
                    for (int i = 0; i < lista_comandos.length - 1; i++) {
                        if (mandato.equals(lista_comandos[i])) {
                            Error = false;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            erroresCometidos++;
            if (erroresCometidos % 3 ==0){showhelp();}
        } while (Error);
        this.comando = mandato;
        this.argumentos = argument;
        this.historial.add(linea);
    }
}
