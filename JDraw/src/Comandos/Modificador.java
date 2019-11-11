package Comandos;
import Figuras.Figura;

public class Modificador {
    private int[] parametros;

    public Modificador(int[] parametros) {
        this.parametros = parametros;
    }

    public int[] getParametros() {
        return parametros;
    }

    public void setParametros(int[] parametros) {
        this.parametros = parametros;
    }

    public Figura modificar_borde (Figura fig){
        fig.setBorde(this.parametros);
        return fig;
    }

    public Figura modificar_color (Figura fig){
        fig.setColor(this.parametros);
        return fig;
    }
}
