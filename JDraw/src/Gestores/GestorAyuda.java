package Gestores;

public class GestorAyuda {
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public GestorAyuda() {
    }
    public void showhelp() {
        System.out.println(ANSI_BLUE+"Los comandos admitidos son los siguientes");
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
}
