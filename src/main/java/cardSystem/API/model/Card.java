package cardSystem.API.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Card {

  private Long id;
  private String numero;
  private String nomeUsuario;
  private String codigoSeguranca;
  private YearMonth dataValidade;
  private String dataValidadeFormato = "mm/yyyy";

  public Card(String numero, String nomeUsuario, String codigoSeguranca, YearMonth dataValidade) {
    this.numero = numero;
    this.nomeUsuario = nomeUsuario;
    this.codigoSeguranca = codigoSeguranca;
    this.dataValidade = dataValidade;
  }

  public String getDataValidade() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dataValidadeFormato);
    return this.dataValidade.format(formatter);
  }

  public void setDataValidade(String dataValidadeInput) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dataValidadeFormato);
    this.dataValidade = YearMonth.parse(dataValidadeInput, formatter);
  }

  public Long getId() {
    return id;
  }

  public String getDataValidadeFormato() {
    return dataValidadeFormato;
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

  public String ultimosQuatroDigitos() {
    final Integer LastDigitsLenght = 4;
    if (numero.length() <= LastDigitsLenght) {
      return numero;
    }
    return numero.substring(numero.length() - LastDigitsLenght);
  }

  public Boolean isValid() {
    LocalDate today = LocalDate.now();
    LocalDate endOfMonthDay = null;

    endOfMonthDay = dataValidade.atEndOfMonth();
    return !today.isAfter(endOfMonthDay);
  }
}
