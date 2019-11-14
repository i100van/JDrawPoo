package Figuras;

import Excepciones.ArgumentosNoValidos;
import Excepciones.ValorNoPermitido;

import java.util.StringJoiner;

public abstract class Figura {
    protected int x;
    protected int y;
    protected int[] color;
    protected int[] borde;

    public Figura(int x, int y) throws ValorNoPermitido {
            if (x >= 0 && y >= 0) {
                this.x = x;
                this.y = y;
                this.color = new int[]{0, 0, 0, 0};
                this.borde = new int[]{1, 0, 0, 0};
            } else throw new ValorNoPermitido();
    }


    abstract public String toString();

    public void setColor(int[] color) {
        this.color = color;
    }

    public void setBorde(int[] borde) {
        this.borde = borde;
    }

    protected String string_Borde_Color() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("stroke-width=\"" + borde[0] + "\" stroke=\"rgb(" + borde[1] + "," + borde[2] + "," + borde[3] + ")\"");
        sj.add("fill=\"rgb(" + color[1] + "," + color[2] + "," + color[3] + ")\" fill-opacity=\"" + color[0] + "\"");
        return sj.toString();
    }
}
