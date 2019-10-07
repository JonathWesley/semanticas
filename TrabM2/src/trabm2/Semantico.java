package trabm2;

import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Semantico implements Constants
{
    Stack stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String variavelAtual;

    public int getResult()
    {
        return ((Integer)stack.peek()).intValue();
    }

    public void executeAction(int action, Token token) throws SemanticError
    {
        Integer a, b;
        
        System.out.println("pilha: "+Arrays.toString(stack.toArray()));
        System.out.println("map: "+vars);
        System.out.println("variavelAtual: "+variavelAtual);
        
        switch (action)
        {
            case 1: //variavel atual
                variavelAtual = token.getLexeme();
                System.out.println("1->"+variavelAtual);
                break;
            case 2: //salva variavel com o valor
                Integer c = (Integer) stack.pop();
                vars.put(variavelAtual, c);
                System.out.println("2->"+variavelAtual+"="+c);
                break;
            case 3: //funcao imprimir
                System.out.println(Integer.toBinaryString(vars.get(variavelAtual)));
                System.out.println("3->imprimindo("+Integer.toBinaryString(vars.get(variavelAtual))+")");
                break;
            case 4: //adicao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() + b.intValue()));
                System.out.println("4->"+a+"+"+b);
                break;
            case 5: //subtracao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() - b.intValue()));
                System.out.println("5->"+a+"-"+b);
                break;
            case 6: //multiplicacao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() * b.intValue()));
                System.out.println("6->"+a+"*"+b);
                break;
            case 7: //divisao
                b = (Integer) stack.pop();
                a = (Integer)stack.pop();
                stack.push(new Integer(a.intValue() / b.intValue()));
                System.out.println("7->"+a+"/"+b);
                break;
            case 8: //exponenciacao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                Double A = Math.pow(a, b);
                stack.push(A.intValue());
                System.out.println("8->"+a+"^"+b);
                break;
            case 9: //empilha numeros
                stack.push(Integer.parseInt(token.getLexeme(),2));
                System.out.println("9->pilha<"+Integer.parseInt(token.getLexeme(),2));
                break;
            case 10: //empilha variavel
                if(!token.getLexeme().equals("imprimir")){
                    stack.push(vars.get(token.getLexeme()));
                    System.out.println("10->pilha<"+vars.get(token.getLexeme()));
                }else{
                    System.out.println("cu");
                }
                
                break; 
        }
    }
}