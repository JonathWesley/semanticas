package trabm2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TrabM2 {
    public static void main(String[] args) throws IOException {
        Lexico lexico = new Lexico();
            
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
            
        String initialString = "A = 100; imprimir(A);";// B = 10; B = 111 + A / B; A = 10 ^ 10;";
        Reader targetReader = new StringReader(initialString);
        lexico.setInput(targetReader);
        
        
        try{
            sintatico.parse(lexico, semantico);
        }catch(LexicalError e){
            System.out.println("Erro lexico.");
            e.printStackTrace();
        }catch(SyntaticError e){
            System.out.println("Erro sintatico.");
            e.printStackTrace();
        }catch(SemanticError e){
            System.out.println("Erro semantico.");
            e.printStackTrace();
        }
    }
}
