import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        int count =  1;
        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arquivo = new FileReader("src/programaFonte.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String linha = lerArquivo.readLine();
            while (linha != null) {
                MetodosDeVerificacao.menuChamaMetodos(linha, count);
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
