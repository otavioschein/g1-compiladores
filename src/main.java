import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class main {
    public static void main(String[] args) {
        int count =  1;
        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arquivo = new FileReader("src/teste.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String linha = lerArquivo.readLine();
            while (linha != null) {
                MetodosDeVerificacao.verificaDeclaracaoDeVariavel(linha, count);
                linha = lerArquivo.readLine();
                count++;
            }

            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
    }



}

//https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
