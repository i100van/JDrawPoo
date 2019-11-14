package Figuras;

import Excepciones.ArgumentosNoValidos;
import Excepciones.ValorNoPermitido;

import java.util.StringJoiner;

public class Linea extends Figura {
    protected int x1;
    protected int y1;

    public Linea(int x, int y, int x1, int y1) throws ValorNoPermitido {
        super(x, y);
        try {
            if (x1 >= 0 && y1 >= 0) {
                this.x1 = x1;
                this.y1 = y1;
            } else throw new ArgumentosNoValidos();
        } catch (ArgumentosNoValidos argumentosNoValidos) {
            System.err.println("Los argumentos no son validos");
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<line x1=\"" + x + "\" y1=\"" + y + "\" x2=\"" + x1 + "\" y2=\"" + y1 + "\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
