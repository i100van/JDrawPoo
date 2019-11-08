import Excepciones.Comando_no_valido;
import Excepciones.NoEsEnteroExcepcion;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPrompt {
    private final String[] lista_comandos = {"line", "circle", "pencolor","fillcolor", "width", "rect","text", "ellipse", "clear","undo","save","load"};
    private String comando;
    private ArrayList<String> historial;
    public GestorPrompt() {
        boolean sinError = false;
        String opcion = null;
        do{
            System.out.println("~$");
            try {
                String linea;
                Scanner scan = new Scanner(System.in);
                linea = scan.nextLine();
                String opcion = linea.split(" ")[0];
                for (int i = 0; i < lista_comandos.length-1; i++) {
                    if(opcion==lista_comandos[i]){
                        sinError=true;
                    }else throw new Comando_no_valido();
                }
            } catch (Comando_no_valido e) {
                System.out.println(e.getMessage());
            }
        }while(!sinError);
        this.comando = opcion;
        historial.add(opcion);
    }

    public String getComando() {
        return comando;
    }
}
