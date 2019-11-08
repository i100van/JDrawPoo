package Comandos;

import Excepciones.Comando_no_valido;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPrompt {
    private final String[] lista_comandos = {"line", "circle", "pencolor","fillcolor", "width", "rect","text", "ellipse", "clear","undo","save","load"};
    private String comando;
    private ArrayList<Integer> argumentos;
    private ArrayList<String> historial;
    public GestorPrompt() {
        boolean Error = true;
        String mandato=null;
        String linea=null;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("~$");
            try {
                linea = scan.nextLine();
                mandato= linea.split(" ")[0];
                String args = linea.split(" ")[1];
                for (int i = 0; i < args.split(",").length-1; i++) {
                    argumentos.add(Integer.parseInt(args.split(",")[i]));
                }
                for (int i = 0; i < lista_comandos.length-1; i++) {
                    if(mandato==lista_comandos[i]){
                        Error=false;
                        break;
                    }else throw new Comando_no_valido();
                }
            } catch (Comando_no_valido e) {
                System.out.println(e.getMessage());
            }
        } while(!Error);
        this.comando = mandato;
        historial.add(linea);
    }

    public String getComando() {
        return comando;
    }

    public String[] getLista_comandos() {
        return lista_comandos;
    }

    public ArrayList<Integer> getArgumentos() {
        return argumentos;
    }
}
