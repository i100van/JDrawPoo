package Gestores;

import Excepciones.ArchivoYaExiste;
import Figuras.Figura;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.StringJoiner;

public class GestorFicheros {
    private File file;
    private RandomAccessFile rfile;
    private String cabecera;
    private final String cierre = "</svg></body></html>";

    public GestorFicheros() throws IOException {
        this.file = new File("JDraw/src/sesion.html");
        this.rfile = new RandomAccessFile(file, "rw");
        this.cabecera = "<html>\n" + " <head>\n" + " <meta charset=\"UTF-8\"/>\n" + " <meta http-equiv=\"refresh\" content=\"2\"/>\n" + " </head>\n" + " <body>\n" + " <svg width=\"1024\" height=\"1024\">\n";
        cargar_Archivo();
        return;
    }

    private void cargar_Archivo() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(String.valueOf(file.toURI())));
    }

    public void escribir_historial(ArrayList<Figura> historial) throws IOException {
        rfile.seek(0);
        StringJoiner sj = getStringJoiner_html_figuras(historial);
        rfile.writeChars(sj.toString());
        rfile.setLength(rfile.getFilePointer());
    }

    private StringJoiner getStringJoiner_html_figuras(ArrayList<Figura> historial) {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(cabecera);
        for (Figura elemento : historial) {
            sj.add(elemento.toString() + "\n");
        }
        sj.add(cierre);
        return sj;
    }


    public void eliminar_documento() throws IOException {
        rfile.close();
        file.delete();
    }

    public void save(String ruta, String nombreFichero, ArrayList<Figura> historial) throws IOException, ArchivoYaExiste {
        StringJoiner sj = getStringJoiner_html_figuras(historial);
        String ruta_nombre = ruta + "/" + nombreFichero + ".html";
        File archivo = new File(ruta_nombre);
        if (!archivo.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(sj.toString());
            bw.close();
        } else {
            throw new ArchivoYaExiste();
        }
    }

    public void load(String ruta, String nombreFichero) throws IOException, ClassNotFoundException {
        String ruta_nombre = ruta + "/" + nombreFichero;
        BufferedReader br = new BufferedReader(new FileReader(ruta_nombre));
        StringBuilder nueva_cabecera = new StringBuilder();
        String linea = br.readLine();
        while (!linea.equals("</svg></body></html>")) {
            nueva_cabecera.append(linea);
            linea = br.readLine();
        }
        cabecera = nueva_cabecera.toString();
        cargar_Archivo();
    }
}
