import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro metodoLivro = new Livro();

        System.out.println("Bem vinde ao sistema de cadastro de Livros");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Digite uma opção: 1 - Cadastrar Livro / 2 - Listrar Livros / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("Digite o titulo do Livro: ");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.println("Digite o nome do Autor: ");
                    novoAutor.nome = leitor.nextLine();

                    System.out.println("Digite o local de nascimento do Autor: ");
                    novoAutor.localNasc = leitor.nextLine();

                    System.out.println("Digite o preço do Livro: ");
                    novoLivro.preco = leitor.nextFloat();
                    leitor.nextLine();
                    System.out.println("Digite a data de lançamento do Livro (dd/mm/aaaa): ");
                    novoLivro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period tempoLancamento = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (tempoLancamento.getYears() >= 5) {
                        System.out.println("Tempo de lançamento válido");
                    } else {
                        System.out.println("Tempo de lançamento inválido");

                    }

                    novoLivro.autor = novoAutor;
                    listaLivro.add(novoLivro);
                    System.out.println("Cadastro realizado com sucesso!");

                    break;
                case "2":
                    if (listaLivro.size() > 0) {
                        for (Livro cadaLivro : listaLivro) {
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local de nascimento do Autor: " + cadaLivro.autor.localNasc);
                            System.out.println("Data de lançamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Preço do livro: " + cadaLivro.preco);
                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }
                    }
                    break;
            }
        } while (!opcao.equals("0"));
    }
}