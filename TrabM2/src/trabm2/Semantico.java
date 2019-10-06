package trabm2;

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

        switch (action)
        {
            case 1: //variavel atual
                variavelAtual = token.getLexeme();
                break;
            case 2: //salva variavel com o valor
                vars.put(variavelAtual, (Integer) stack.pop());
                break;
            case 3: //funcao imprimir
                System.out.println(Integer.toBinaryString(vars.get(variavelAtual)));
                break;
            case 4: //adicao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() + b.intValue()));
                break;
            case 5: //subtracao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() - b.intValue()));
                break;
            case 6: //multiplicacao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(new Integer(a.intValue() * b.intValue()));
                break;
            case 7: //divisao
                b = (Integer) stack.pop();
                a = (Integer)stack.pop();
                stack.push(new Integer(a.intValue() / b.intValue()));
                break;
            case 8: //exponenciacao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                Double A = Math.pow(a, b);
                stack.push(A.intValue());
                break;
            case 9: //empilha numeros
                stack.push(Integer.parseInt(token.getLexeme(),2));
                break;
            case 10: //empilha variavel
                stack.push(vars.get(token.getLexeme()));
                break; 
        }
    }
}