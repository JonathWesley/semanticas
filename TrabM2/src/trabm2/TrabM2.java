package trabm2;

import java.io.IOException;

public class TrabM2 {
    public static void main(String[] args) {
        try{
            Lexico lexico = new Lexico("A = 100; B = 10;  B=111 + A / B; imprimir(B);");
            
            Sintatico sintatico = new sintatico();
            Semantico semantico = new semantico();
            
            Sintatico.parse(lexico, semantico);
        }catch(LexicalError | SyntaticError | SemanticError e){
            System.out.println("Erro ao interpretar comando.");
        }
    }
}
