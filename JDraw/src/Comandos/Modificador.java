package Comandos;

import Excepciones.ArgumentosNoValidos;
import Figuras.Figura;

public class Modificador {
    private int[] parColor;
    private int[] parBorde;

    public Modificador() {
        this.parColor = new int[]{0, 0, 0, 0};
        this.parBorde = new int[]{1, 0, 0, 0};
    }

    public void setParColor(int[] parColor) throws ArgumentosNoValidos {
        Boolean error = false;
        if (parColor[0] < 0 || parColor[1] > 1) {
            error = true;
        } else {
            for (int i = 1; i < parColor.length - 1; i++) {
                if (parColor[i] < 0 || parColor[i] > 256) {
                    error = true;
                }
            }
        }
        if (!error) {
            this.parColor = parColor;
        } else throw new ArgumentosNoValidos();
    }

    public void setParBorde(int[] parBorde) throws ArgumentosNoValidos {
        Boolean error = false;
        //TODO: Preguntar si el pencolor va de 0 a 1 como pone en la practica, dabido a que no es opacidad sino grosor
        for (int i = 1; i < parBorde.length - 1; i++) {
            if (parBorde[i] < 0 || parBorde[i] > 256) {
                error = true;
            }
        }
        if (!error) {
            this.parBorde = parBorde;
        } else throw new ArgumentosNoValidos();
    }
    public void setAncho (int ancho) throws ArgumentosNoValidos {
        if(ancho>0){
            parBorde[0]=ancho;
        }else throw new ArgumentosNoValidos();
    }

    public Figura actuar_en_Figura(Figura fig) {
        fig.setColor(parColor);
        fig.setBorde(parBorde);
        return fig;
    }
}
