import Excepciones.ArchivoYaExiste;
import Figuras.Figura;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.StringJoiner;

public class OperadorFicheros {
    private File file;
    private RandomAccessFile rfile;
    private String cabecera = "<html>\n" + " <head>\n" + " <meta charset=\"UTF-8\"/>\n" + " <meta http-equiv=\"refresh\" content=\"2\"/>\n" + " </head>\n" + " <body>\n" + " <svg width=\"1024\" height=\"1024\">\n";
    private final String cierre = "</svg></body></html>";

    public OperadorFicheros() throws IOException {
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        this.rfile = new RandomAccessFile(file, "rw");
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
        sj.add("\n" + cierre);
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
        BufferedWriter bw;
        if (!archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(sj.toString());
            bw.close();
        } else {
            throw new ArchivoYaExiste();
        }
    }

    public void load(String ruta, String nombreFichero) throws IOException, ClassNotFoundException {
        String ruta_nombre = ruta + "/" + nombreFichero;
        file = new File(ruta_nombre);
        rfile = new RandomAccessFile(file, "rw");
        String linea = rfile.readLine();
        cabecera = "";
        while (!linea.equals("</svg></body></html>")) {
            cabecera = cabecera + linea;
            linea = rfile.readLine();
        }
        cargar_Archivo();
    }
}
