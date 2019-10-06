package trabm2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.StringReader;

public class TrabM2 {
    public static void main(String[] args) throws IOException {
        Lexico lexico = new Lexico();
            
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
            
        String initialString = "A = 100; B = 10; B = 111 + A / B; imprimir(B);";
        Reader targetReader = new StringReader(initialString);
        lexico.setInput(targetReader);
        
        
        try{
            sintatico.parse(lexico, semantico);
        }catch(LexicalError | SyntaticError | SemanticError e){
            System.out.println("Erro ao interpretar comando.");
        }
    }
}
