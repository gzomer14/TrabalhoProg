package unesc.analisador;


import java.util.Stack;

public class AnalisadorLexico {
    
    public Stack<String> gerarTokens(String programa){
        String[] tokens = programa.split(" ");
        Stack<String> pilhaTokens = new Stack<>();
        
        for (String elemento : tokens)
        {
            if (elemento.isEmpty() || elemento == " ")
            {
                continue;
            }
            pilhaTokens.push(elemento);
        }    
        
       Stack<String> pilhaInvertida = new Stack<>();
        
       int i = pilhaTokens.size();
       
        while(!pilhaTokens.isEmpty())
        {
            pilhaInvertida.push(pilhaTokens.pop());
        }
        
//        Integer valor = null;
//        try {
//            valor = Integer.valueOf("1050");
//        }catch(Exception e) {
//        }
        
        //aqui
        
        return pilhaInvertida;
    }
    
}
