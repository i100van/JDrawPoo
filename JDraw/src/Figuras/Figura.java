package Figuras;

import java.util.StringJoiner;

public abstract class Figura {
    protected int x;
    protected int y;
    protected int[] color;
    protected int[] borde;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
        this.color= new int[]{1,0,0,0};
    }
    abstract public String toString();

    public void setColor(int[] color) {
        this.color = color;
    }

    public void setBorde(int[] borde) {
        this.borde = borde;
    }

    protected String string_Borde_Color (){
        StringJoiner sj = new StringJoiner(" ");
        if (this.color!=null){
            sj.add("stroke-width=\""+color[0]+"\" stroke=\"rgb("+color[1]+","+color[2]+","+color[3]+")\"");
        }
        if (this.borde!=null){
            sj.add("fill=\"rgb("+borde[1]+","+borde[2]+","+borde[3]+")\" fill-opacity=\""+borde[0]+"\"");
        }
        return sj.toString();
    }
}
