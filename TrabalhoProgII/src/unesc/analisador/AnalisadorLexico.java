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
       Integer valor = null;
       
        while(!pilhaTokens.isEmpty())
        {
            String elemento = pilhaTokens.pop();
            
            try {
                valor = Integer.valueOf(elemento);
                elemento = "INTEIRO";
            }catch(Exception e) {
            }
            
            pilhaInvertida.push(elemento);
        }
        
        //aqui
        
        return pilhaInvertida;
    }
    
}
