import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class main {
    public static void main(String[] args) {

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arquivo = new FileReader("src/teste.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String linha = lerArquivo.readLine();
            while (linha != null) {
//                System.out.printf("%s\n", linha);
                verificaIf(linha);
                linha = lerArquivo.readLine(); // lê da segunda até a última linha
            }

            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
    }

    public static void verificaIf(String string) {
        System.out.println(string);

        Boolean matchFound = string.matches("if[(] []? [)]");

        if (matchFound) {
            System.out.println("Match found.");
            System.out.println();
        } else {
            System.out.println("Match not found.");
            System.out.println();
        }
    }

}

https://www.vogella.com/tutorials/JavaRegularExpressions/article.html

