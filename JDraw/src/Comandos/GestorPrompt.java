package Comandos;

import Excepciones.ComandoNoValido;

import java.util.ArrayList;
import java.util.Scanner;


public class GestorPrompt {

    private final String[] COMANDOS = {"line", "circle", "pencolor", "fillcolor", "width", "rect", "text", "ellipse", "clear", "undo", "save", "load"};
    private final int[] ARGUMENTOS = {4,3,4,4,1,4,3,4,0,0,2,2};

    private String comando;
    private ArrayList argumentos;
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
        int erroresCometidos = 0;
        Scanner scan = new Scanner(System.in);
        String mandato = null;
        String linea = null;
        while (Error){//TODO remodelar esto con una matriz de copmandos y su numero de parametros para comprobar que la entrada es correcta
            System.out.print("JDraw ~$: ");
            try {
                linea = scan.nextLine();
                //Comprobar la forma
                if (linea.split(" ").length == 2) {
                    mandato = linea.split(" ")[0];
                    String[] args = linea.split(" ")[1].split(",");
                    //Comprobar el comando y el numero de argumentos
                    for (int i = 0; i < COMANDOS.length - 1; i++) {
                        if (mandato.equals(COMANDOS[i]) && args.length==ARGUMENTOS[i] ) {
                            Error = false;
                            //Si es comando text el ultimo parametro debe ser un string
                            if(!mandato.equals("text")){
                                for (int j = 0; j < (args.length); j++) {
                                    argument.add(Integer.parseInt(args[j]));
                                }
                            }else{
                                for (int j = 0; j < (args.length)-1; j++) {
                                    argument.add(Integer.parseInt(args[j]));
                                }
                                this.text=args[2];
                            }
                            break;
                        }
                    }
                } else throw new ComandoNoValido();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //Mostrar la ayuda en caso de 3 errores
            erroresCometidos++;
            if (erroresCometidos % 3 == 0) {
                Help ayuda = new Help();
                ayuda.showhelp();
            }
        }
        System.out.println("No ha habido error");
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
