package trabalhador.application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import trabalhador.entities.ContratoHora;
import trabalhador.entities.Departamento;
import trabalhador.entities.Trabalhador;
import trabalhador.entities_enumeracao.NivelTrabalhador;

public class Programa {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    for (int i = 0; i < 100; ++i)
      System.out.println();

    System.out.print("Qual é o nome do departamento? ");
    String nomeDepartamento = sc.nextLine();
    System.out.println("Dados do trabalhador:");
    System.out.print("nome: ");
    String nome = sc.nextLine();
    System.out.print("Nível trabalhador: ");
    String nivel = sc.nextLine();
    System.out.print("Salário base: ");
    double salarioBase = sc.nextDouble();
    Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase,
        new Departamento(nomeDepartamento));

    System.out.print("Quantos contratos o trabalhador terá? ");
    int n = sc.nextInt();

    for (int i = 0; i < 100; ++i)
      System.out.println();

    for (int i = 1; i <= n; i++) {

      for (int j = 0; j < 100; ++j) {
        System.out.println();
      }

      System.out.println("Dados do contrato #" + i);
      System.out.print("Data (DD/MM/AAAA): ");
      Date dataContrato = sdf.parse(sc.next());
      System.out.print("Valor por hora: ");
      double valorHora = sc.nextDouble();
      System.out.print("Quantas horas de contrato? ");
      int horas = sc.nextInt();
      ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
      trabalhador.addContrato(contrato);
    }
    System.out.println();
    System.out.print("Digite o mês e ano do contrato (MM/AAAA): ");
    String mesAno = sc.next();
    int mes = Integer.parseInt(mesAno.substring(0, 2));
    int ano = Integer.parseInt(mesAno.substring(3));

    for (int i = 0; i < 100; ++i)
      System.out.println();

    System.out.println("Nome: " + trabalhador.getNome());
    System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
    System.out.println("Salário em " + mesAno + ": R$" + String.format("%.2f", trabalhador.calculo(ano, mes)));

    sc.close();
  }
}
