import Figuras.Figura;

import java.io.*;
import java.util.Scanner;

public class Fichero {
    private File file;
    private BufferedWriter bfw;
    private BufferedReader bfr;
    private RandomAccessFile rfile;

    public Fichero() throws IOException {
        //this.file = File.createTempFile("jdraw_tmp_file", "html");
        this.file = new File("C:/Users/i100v/IntelliJIDEAProjects/JDrawPoo/JDraw/src/pruebas.html");
        this.bfr = new BufferedReader(new FileReader(file));
        this.bfw = new BufferedWriter(new FileWriter(file));
        this.rfile = new RandomAccessFile(file, "rw");
        rfile.writeBytes("<html>\n" +
                " <head>\n" +
                " <meta charset=\"UTF-8\"/>\n" +
                " <meta http-equiv=\"refresh\" content=\"2\"/>\n" +
                " </head>\n" +
                " <body>\n" +
                " <svg width=\"1024\" height=\"1024\">\n"+
                "</svg>"+"</body>"+"</html>");
    }

    /*public void escribir_figura () throws IOException {
        String linea = bfr.readLine();
        while(!linea.equals(" <svg width=\"1024\" height=\"1024\">")){
            linea=bfr.readLine();
        }
        String newLine = linea+ "patata";
        bfw.write(newLine);
    }*/
}
