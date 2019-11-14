package Figuras;

import Excepciones.ValorNoPermitido;

import java.util.StringJoiner;

public class Circulo extends Figura {
    private int radio;

    public Circulo(int x, int y, int radio) throws ValorNoPermitido {
        super(x, y);
        try {
            if (radio > 0) {
                this.radio = radio;
            } else throw new ValorNoPermitido();
        } catch (ValorNoPermitido valorNoPermitido) {
            System.err.println(valorNoPermitido);
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + radio + "\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
