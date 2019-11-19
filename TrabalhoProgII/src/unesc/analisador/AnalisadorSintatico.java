package unesc.analisador;


import unesc.gramatica.Gramatica;
import java.util.Map;
import java.util.Stack;

public class AnalisadorSintatico {
    
    private final Map<String, Integer> linguagem = Gramatica.LINGUAGEM;
    private final Map<String, String> gramatica = Gramatica.GRAMATICA;
    
    public void analisar(Stack<String> tokens) {
        
        Stack<Integer> pilhaInteiro = new Stack<>();
        
        while(!tokens.isEmpty())
        {
            Integer teste = getIdentificadorOuInteiro(tokens.peek());
            
            Integer topoTokens = linguagem.get(tokens.peek());
            
            if (topoTokens != null)
            {
                tokens.pop();
            }
            else
            {
                Integer identOrInt = getIdentificadorOuInteiro(tokens.peek());
                if (identOrInt != null)
                {
                    tokens.pop();
                }
            }
        }
    }    
    
    /**
     Este método verifica se um token é um IDENTIFICADOR ou um INTEIRO
     */
    private Integer getIdentificadorOuInteiro(String token) {
        //verifica se é um identificador ou inteiro
        char[] cList = token.toCharArray();
        boolean identificador = true;
        for(char c : cList) {
            if(Character.getType(c) != Character.UPPERCASE_LETTER) {
                identificador = true;
            }
        }

        if(identificador) {
            return linguagem.get("IDENTIFICADOR");
        } 
        return linguagem.get("INTEIRO");
    }
}
