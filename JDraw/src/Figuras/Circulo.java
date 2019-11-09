package Figuras;

import java.util.StringJoiner;

public class Circulo extends Figura{
    private int radio;

    public Circulo(int x, int y, int radio) {
        super(x, y);
        this.radio = radio;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("<circle cx=\"" + x + "\" cy=\""+ y +"\" r=\""+ radio +"\"");
        sj.add(string_Borde_Color());
        sj.add("/>");
        return sj.toString();
    }
}
