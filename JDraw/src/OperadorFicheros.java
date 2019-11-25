import Figuras.Figura;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.StringJoiner;

public class OperadorFicheros {
    private File file;
    private RandomAccessFile rfile;
    private final String cabecera ="<html>\n" + " <head>\n" + " <meta charset=\"UTF-8\"/>\n" + " <meta http-equiv=\"refresh\" content=\"2\"/>\n" + " </head>\n" + " <body>\n" + " <svg width=\"1024\" height=\"1024\">\n";
    private final String cierre ="</svg></body></html>";

    public OperadorFicheros() throws IOException {
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        this.rfile = new RandomAccessFile(file, "rw");
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
    }

    public void escribir_historial (ArrayList<Figura> historial) throws IOException {
        rfile.seek(0);
        StringJoiner sj = getStringJoiner_html_figuras(historial);
        rfile.writeChars(sj.toString());
        rfile.setLength(rfile.getFilePointer());
    }

    private StringJoiner getStringJoiner_html_figuras(ArrayList<Figura> historial) {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(cabecera);
        for (Figura elemento: historial) {
            sj.add(elemento.toString()+"\n");
        }
        sj.add("\n"+cierre);
        return sj;
    }

    /*public void vaciar_documento() throws IOException {
        rfile.seek(0);
        long longitud = file.length();
        System.out.println("longitud = " + longitud);
        for (int i = 0; i < longitud; i++) {
            rfile.writeChars("");
        }
    }*/

    public void eliminar_documento() throws IOException {
        file.delete();
        rfile.close();
    }

    public void save (String ruta, String nombreFichero, ArrayList<Figura> historial) throws IOException {
        StringJoiner sj = getStringJoiner_html_figuras(historial);
        String ruta_nombre = ruta+"/"+nombreFichero;
        File archivo = new File(ruta_nombre);
        BufferedWriter bw;
        if(!archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(sj.toString());
            bw.close();
        }
    }
    public void load (String ruta, String nombreFichero){
        //TODO: despues de hacer un load, se tiene que poder seguir escribiendo el documento? si es asi, dos opciones:
        // localizar la tag </svg> y escribir justo encima o introducir al historial todas las figuras que tenga el file
    }
}
