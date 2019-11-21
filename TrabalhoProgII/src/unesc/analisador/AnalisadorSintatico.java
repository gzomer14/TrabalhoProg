package unesc.analisador;


import unesc.gramatica.Gramatica;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Stack;

public class AnalisadorSintatico {
    
    private final Map<String, Integer> linguagem = Gramatica.LINGUAGEM;
    private final Map<String, String> gramatica = Gramatica.GRAMATICA;
    
    public void analisar(Stack<String> tokens) {
        Stack<Integer> pilhaInt = new Stack();
        
        pilhaInt.add(linguagem.get("PROGRAMA"));
        
        while(!tokens.isEmpty() && !pilhaInt.isEmpty())
        {
            Integer tokensTopo = linguagem.get(tokens.peek());
            Integer pilhaIntTopo = pilhaInt.peek();
            
            if (tokensTopo == null)
            {
                tokensTopo = getIdentificadorOuInteiro(tokens.peek());
            }
            
            //Terminal
            if (pilhaIntTopo != null && pilhaIntTopo < 52)
            {
                if (pilhaIntTopo == tokensTopo)
                {
                    tokens.pop();
                    pilhaInt.pop();
                }
                else
                {
                    System.out.println("Erro encontrado!\nO valor " + tokensTopo + " esta em uma posição incorreta");
                    break;
                }
            }
            //Não terminal
            else
            {
                String opcoes = gramatica.get(pilhaIntTopo + "," + tokensTopo);

                Integer[] opcoesInteger = Gramatica.geraDadosCruzamentoTabParsingToken(opcoes);

                if (opcoes == null)
                {
                    pilhaInt.pop();
                }
                else
                {
                    pilhaInt.pop();
                    for (int i = opcoesInteger.length - 1; i >=0 ; i--)
                    {
                        pilhaInt.push(opcoesInteger[i]);
                    }
                }
            }
        }

        if (tokens.empty())
        {
            System.out.println("Código correto");
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
