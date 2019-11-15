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
    private final String cabecera ="<html>\n" + " <head>\n" + " <meta charset=\"UTF-8\"/>\n" + " <meta http-equiv=\"refresh\" content=\"2\"/>\n" + " </head>\n" + " <body>\n" + " <svg width=\"1024\" height=\"1024\">\n";
    private final String cierre ="</svg></body></html>";

    public Fichero() throws IOException {
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        //this.file = File.createTempFile("jdraw_tmp_file", "html");
        //String fileName = file.getAbsolutePath();
        this.rfile = new RandomAccessFile(file, "rw");
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
    }

    public void escribir_historial (ArrayList<Figura> historial) throws IOException {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(cabecera);
        for (Figura elemento: historial) {
            sj.add(elemento.toString());
        }
        sj.add(cierre);
        rfile.seek(0);
        rfile.writeChars(sj.toString());
    }
    public void vaciar_documento() throws IOException {
        //TODO: Esto funciona mal, porque se queda el texto previo
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("");
        bw.close();
    }

    public void save (String ruta, String nombreFichero) throws IOException {
        //TODO: Hay que hacerlo
    }
}
