import Comandos.GestorPrompt;

public class InterfazUsuario {
    public InterfazUsuario (){
        boolean fin=false;
        while(!fin){
            GestorPrompt prompt = new GestorPrompt();
            String comando=prompt.getComando();
            switch (comando){
                case "line":

                case "rect":

                case "circle":

                case "text":

                case "ellipse":

                case "pencolor":

                case "fillcolor":

                case "width":

                case "clear":

                case "undo":

                case "save":

                case "load":

            }

        }

    }
}
