package Comandos;

import Excepciones.ArgumentosNoValidos;

public class Modificador {
    private int o;
    private int red;
    private int green;
    private int blue;

    public Modificador(int o, int[] rgb) throws ArgumentosNoValidos {
        //TODO cambiar el constructor
        boolean bien=true;
        for (int i = 0; i < rgb.length-1; i++) {
            if(o<0 | o>1 | rgb[i]<0 | rgb[i]>255){
                bien=false;
                break;
            }
        }
        if(bien){
            this.o=o;
            this.rgb=rgb;
        }else throw new ArgumentosNoValidos();

    }
}
