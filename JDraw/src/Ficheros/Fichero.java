package Ficheros;

import Figuras.Figura;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Fichero {
    private File file;
    private RandomAccessFile rfile;

    public Fichero() throws IOException {
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        this.rfile = new RandomAccessFile(file, "rw");
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
    }

    public void escribir_historial (ArrayList<Figura> historial) throws IOException {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<html>\n" +
                " <head>\n" +
                " <meta charset=\"UTF-8\"/>\n" +
                " <meta http-equiv=\"refresh\" content=\"2\"/>\n" +
                " </head>\n" +
                " <body>\n" +
                " <svg width=\"1024\" height=\"1024\">\n");
        for (Figura elemento: historial) {
            sj.add(elemento.toString());
        }
        sj.add("</svg></body></html>");
        rfile.seek(0);
        rfile.writeChars(sj.toString());
    }
    public void vaciar_documento() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.file));
        bw.write("");
        bw.close();
    }
}
