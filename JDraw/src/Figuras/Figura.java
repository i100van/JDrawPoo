package Figuras;

import Excepciones.ValorNoPermitido;

import java.io.Serializable;
import java.util.StringJoiner;

public abstract class Figura implements Serializable {
    protected int x;
    protected int y;
    protected int[] color;
    protected int[] borde;
    protected float op_borde;
    protected float op_color;
    protected int width;

    public Figura(int x, int y) throws ValorNoPermitido {
            if (x >= 0 && y >= 0) {
                this.x = x;
                this.y = y;
                this.color = new int[]{0, 0, 0};
                this.borde = new int[]{0, 0, 0};
                this.op_color=0;
                this.op_borde=1;
                this.width=1;
            } else throw new ValorNoPermitido();
    }


    abstract public String toString();

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(int[] color, float op_color) {
        this.color = color;
        this.op_color=op_color;
    }

    public void setBorde(int[] borde,float op_borde) {
        this.borde = borde;
        this.op_borde=op_borde;
    }

    protected String string_Borde_Color() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("stroke-width=\"" + width + "\" stroke-opacity=\"" + op_borde + "\" stroke=\"rgb(" + borde[0] + "," + borde[1] + "," + borde[2] + ")\"");
        sj.add("fill=\"rgb(" +color[0]+ "," + color[1] + "," + color[2] + ")\" fill-opacity=\"" + op_color + "\"");
        return sj.toString();
    }
}
