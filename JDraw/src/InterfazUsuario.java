import Comandos.GestorPrompt;

public class InterfazUsuario {
    public InterfazUsuario (){
        boolean fin=false;
        GestorPrompt prompt = new GestorPrompt();
        while(!fin){
            prompt.pedir_comando();
            System.out.println(prompt.getlista_comandos());
            String comando=prompt.getComando();
            switch (comando){
                case "line":
                    System.out.println("Estoy dibujando linea");
                    break;
                case "rect":
                    break;
                case "circle":
                    break;
                case "text":
                    break;
                case "ellipse":
                    break;
                case "pencolor":
                    break;
                case "fillcolor":
                    break;
                case "width":
                    break;
                case "clear":
                    break;
                case "undo":
                    break;
                case "save":
                    break;
                case "load":
                    break;
                case "exit":
                    fin=true;

            }

        }

    }
}
