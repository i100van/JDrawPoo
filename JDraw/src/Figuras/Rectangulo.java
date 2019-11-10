package Figuras;

import Excepciones.ArgumentosNoValidos;

import java.util.StringJoiner;

public class Rectangulo extends Figura {
    private int w;
    private int h;

    public Rectangulo(int x, int y, int w, int h) throws ArgumentosNoValidos {
        super(x, y);
        if (w > 0 && h > 0) {
            this.w = w;
            this.h = h;
        } else throw new ArgumentosNoValidos();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + w + "\" height=\"" + h + "\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
