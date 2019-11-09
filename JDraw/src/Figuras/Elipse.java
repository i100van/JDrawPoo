package Figuras;

import java.util.StringJoiner;

public class Elipse extends Figura {
    private int rx;
    private int ry;

    public Elipse(int x, int y, int rx, int ry) {
        super(x, y);
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<ellipse cx=\"" + x + "\" cy=\""+ y +"\" rx=\""+ rx +"\" ry=\""+ ry + "\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
