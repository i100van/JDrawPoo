package Figuras;

import Excepciones.ArgumentosNoValidos;

import java.util.StringJoiner;

public class Elipse extends Figura {
    private int rx;
    private int ry;

    public Elipse(int x, int y, int rx, int ry) throws ArgumentosNoValidos {
        super(x, y);
        if (rx > 0 && ry > 0) {
            this.rx = rx;
            this.ry = ry;
        } else throw new ArgumentosNoValidos();
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<ellipse cx=\"" + x + "\" cy=\"" + y + "\" rx=\"" + rx + "\" ry=\"" + ry + "\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
