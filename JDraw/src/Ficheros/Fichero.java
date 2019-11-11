package Ficheros;

import Figuras.Figura;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class Fichero {
    private File file;
    private PrintWriter wr;

    public Fichero() throws IOException {
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        this.wr = (new PrintWriter(new BufferedWriter(new FileWriter(file))));
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
        wr.write("<html>\n" +
                " <head>\n" +
                " <meta charset=\"UTF-8\"/>\n" +
                " <meta http-equiv=\"refresh\" content=\"2\"/>\n" +
                " </head>\n" +
                " <body>\n" +
                " <svg width=\"1024\" height=\"1024\">\n"+
                //Aqui habria que insertar las figuras
                "</svg></body></html>"
                );
    }

    public void escribir_figura (String figura) throws IOException {
        wr.append(figura);
    }


    public void escribir_Historial(ArrayList<Figura> historial) {
    }
}
