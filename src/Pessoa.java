import java.time.LocalDate;
import java.time.Period;
import java.time.LocalTime;

public class Pessoa {
    private final String nome;
    private double altura;
    private int peso;
    private final LocalDate nascimento;


    public Pessoa(String nome, double altura, int peso, LocalDate nascimento) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }


    public int getIdade(LocalDate nascimento) { //TODO: Calculo da idade ;)
        LocalDate dataAtual = LocalDate.now();
        return Period.between(this.nascimento, dataAtual).getYears();
    }

    public String saudacao(LocalTime horas) { //TODO: Metodo para horas :)
        int hora = horas.getHour(); // vai obter a hora atual

        return switch (hora) {
            case 5, 6, 7, 8, 9, 10, 11 -> "Bom dia";
            case 12, 13, 14, 15, 16, 17 -> "Boa tarde";
            case 0, 1, 2, 3, 4, 18, 19, 20, 21, 22, 23 -> "Boa Noite";
            default -> "Hora inválida";
        };
    }

    public double getIMC() { //TODO: Calculo do IMC :)
        return peso / (altura * altura);  // Calcula e retorna o IMC
    }

    public String classificarIMC() {
        double IMC = getIMC();

        if (IMC < 18.5) {
            return "Abaixo do peso ideal";
        } else if (IMC >= 18.5 && IMC < 25) {
            return "Peso ideal";
        } else if (IMC >= 25 && IMC < 30) {
            return "Acima do peso ideal";
        } else if (IMC >= 30 && IMC < 35) {
            return "Obesidade grau 1";
        } else if (IMC >= 35 && IMC < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }



    public String toString() {
        LocalTime agora = LocalTime.now();
        String saudacao = saudacao(agora);

        return String.format("Olá %s! %s.\n", nome, saudacao) +
                String.format("%s, sua idade é %d anos.\n", nome, getIdade(nascimento)) +
                String.format("%s, o seu IMC é: %.2f\n", nome, getIMC()) +
                String.format("%s, a sua classificação de IMC é: %s\n", nome, classificarIMC());
    }
}
