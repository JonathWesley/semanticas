package trabm2;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class TrabM2 {
    public static void main(String[] args) throws IOException {
        Lexico lexico = new Lexico();
            
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        
        Scanner scanner = new Scanner(System.in);
        String initialString = scanner.nextLine();//"C = 101; A = 100; B = 10; B = 111 + A / B; ->(B); ->(A); ->(C);";
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
