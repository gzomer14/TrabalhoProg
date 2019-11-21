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
       
        while(!pilhaTokens.isEmpty())
        {
            String elemento = pilhaTokens.pop();
            
            pilhaInvertida.push(elemento);
        }
        
        return pilhaInvertida;
    }
    
}
