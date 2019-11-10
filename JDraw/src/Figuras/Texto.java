package Figuras;
import Excepciones.ArgumentosNoValidos;

import java.util.StringJoiner;

public class Texto extends Figura {
    private String texto;

    public Texto(int x, int y, String texto) throws ArgumentosNoValidos {
        super(x, y);
        this.texto = texto;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<text x=\"" + x + "\" y=\""+ y +"\"");
        sj.add(string_Borde_Color());
        sj.add(">");
        sj.add(texto);
        sj.add("</text>");
        return sj.toString();
    }
}
