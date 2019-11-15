package Comandos;

import Excepciones.ArgumentosNoValidos;
import Figuras.Figura;

public class Modificador {
    private int[] rgbColor;
    private float opacidad_color;
    private int[] rgbBorde;
    private float opacidad_borde;
    private int width;

    public Modificador() {
        this.rgbColor = new int[]{0, 0, 0};
        this.rgbBorde = new int[]{0, 0, 0};
        this.opacidad_borde=1;
        this.opacidad_color=0;
        this.width=1;
    }

    public void setParColor(float op,int[] parColor) throws ArgumentosNoValidos {
        Boolean error = false;
        if (op < 0 || op > 1) {
            error = true;
        }
        for (int i = 1; i < parColor.length - 1; i++) {
            if (parColor[i] < 0 || parColor[i] > 256) {
                error = true;
            }
        }
        if (!error) {
            this.rgbColor = parColor;
            this.opacidad_color=op;
        } else throw new ArgumentosNoValidos();
    }

    public void setParBorde(float op, int[] parBorde) throws ArgumentosNoValidos {
        Boolean error = false;
        if (op < 0 || op > 1) {
            error = true;
        }
        for (int i = 1; i < parBorde.length - 1; i++) {
            if (parBorde[i] < 0 || parBorde[i] > 256) {
                error = true;
            }
        }
        if (!error) {
            this.rgbBorde = parBorde;
            this.opacidad_borde=op;
        } else throw new ArgumentosNoValidos();
    }
    public void setAncho (int ancho) throws ArgumentosNoValidos {
        if(ancho>0){
            width=ancho;
        }else throw new ArgumentosNoValidos();
    }

    public Figura actuar_en_Figura(Figura fig) {
        fig.setColor(rgbColor,opacidad_color);
        fig.setBorde(rgbBorde,opacidad_borde);
        fig.setWidth(width);
        return fig;
    }
}
