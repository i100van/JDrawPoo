package Comandos;

import Excepciones.ArgumentosNoValidos;

public class Modificador {
    private int opacidad;
    private int[] rgb;

    public Modificador(int opacidad, int[] rgb) throws ArgumentosNoValidos {
        if (opacidad < 1 && opacidad < 0) {
            for (int i = 0; i < rgb.length - 1; i++) {
                if (rgb[i] >= 0 | rgb[i] <= 255) {
                    this.opacidad=opacidad;
                    this.rgb=rgb;
                }else throw new ArgumentosNoValidos();
            }
        } else {
            throw new ArgumentosNoValidos();
        }
    }

    public int getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(int opacidad) {
        this.opacidad = opacidad;
    }

    public int[] getRgb() {
        return rgb;
    }

    public void setRgb(int[] rgb) {
        this.rgb = rgb;
    }
}
