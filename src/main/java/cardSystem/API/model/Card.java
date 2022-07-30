package cardSystem.API.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Card {

  private Long id;
  private String numero;
  private String nomeUsuario;
  private String codigoSeguranca;
  private YearMonth dataValidade;
  private String dataValidadeFormato = "mm/yyyy";

  public Card() {
  }

  public String getDataValidade() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dataValidadeFormato);
    return this.dataValidade.format(formatter);
  }

  public void setDataValidade(String dataValidadeInput) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dataValidadeFormato);
    this.dataValidade = YearMonth.parse(dataValidadeInput, formatter);
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getCodigoSeguranca() {
    return codigoSeguranca;
  }

  public void setCodigoSeguranca(String codigoSeguranca) {
    this.codigoSeguranca = codigoSeguranca;
  }
}
