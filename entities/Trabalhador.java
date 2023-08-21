package trabalhador.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import trabalhador.entities_enumeracao.NivelTrabalhador;

public class Trabalhador {
  private String nome;
  private NivelTrabalhador nivel;
  private Double salarioBase;

  private Departamento departamento;
  private List<ContratoHora> contratos = new ArrayList<>();

  public Trabalhador() {
  }

  public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
    this.nome = nome;
    this.nivel = nivel;
    this.salarioBase = salarioBase;
    this.departamento = departamento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public NivelTrabalhador getNivel() {
    return nivel;
  }

  public void setNivel(NivelTrabalhador nivel) {
    this.nivel = nivel;
  }

  public Double getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(Double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public List<ContratoHora> getContratos() {
    return contratos;
  }

  public void addContrato(ContratoHora contrato) {
    contratos.add(contrato);
  }

  public void removeContrato(ContratoHora contrato) {
    contratos.remove(contrato);
  }

  public double calculo(int ano, int mes) {
    double soma = salarioBase;
    Calendar cal = Calendar.getInstance();

    for (ContratoHora contratoHora : contratos) {
      cal.setTime(contratoHora.getData());
      int contrato_ano = cal.get(Calendar.YEAR);
      int contrato_mes = 1 + cal.get(Calendar.MONTH);

      if (ano == contrato_ano && mes == contrato_mes) {
        soma += contratoHora.valorTotal();
      }
    }
    return soma;
  }
}
