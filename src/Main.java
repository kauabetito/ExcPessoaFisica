import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite a sua altura: ");
        double altura = entrada.nextDouble();

        System.out.print("Digite o seu peso: ");
        int peso = entrada.nextInt();

        System.out.print("Digite a data do seu nascimento (dd/MM/yyyy): ");
        String nascimentoInput = entrada.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate nascimento = LocalDate.parse(nascimentoInput, formatter);
        Pessoa pessoa = new Pessoa(nome, altura, peso, nascimento);



        pessoa.exibirInfo();
        entrada.close();
    }
}
