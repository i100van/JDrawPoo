package Ficheros;

import java.awt.*;
import java.io.*;
import java.net.URI;

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
                " <svg width=\"1024\" height=\"1024\">\n"
                );
    }

    public void escribir_figura (String figura) throws IOException {
        wr.append(figura);
    }
    public void cerrar_fichero() throws IOException {
        wr.append("</svg></body></html>");
        wr.close();
    }
}
