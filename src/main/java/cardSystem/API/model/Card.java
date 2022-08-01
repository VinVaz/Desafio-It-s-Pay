package cardSystem.API.model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(name = "numero")
  private String numero;

  @Column(name = "nomeUsuario")
  private String nomeUsuario;

  @Column(name = "codigoSeguranca")
  private String codigoSeguranca;

  @Column(name = "dataValidade")
  private YearMonth dataValidade;

  public static final String DATA_VALIDADE_FORMATO = "mm/yyyy";

  public Card(String numero, String nomeUsuario, String codigoSeguranca, YearMonth dataValidade) {
    this.numero = numero;
    this.nomeUsuario = nomeUsuario;
    this.codigoSeguranca = codigoSeguranca;
    this.dataValidade = dataValidade;
  }

  public YearMonth getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(YearMonth dataValidadeInput) {
    this.dataValidade = dataValidadeInput;
  }

  public String dataValidadeFormatado() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA_VALIDADE_FORMATO);
    return this.dataValidade.format(formatter);
  }

  public Long getId() {
    return id;
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
    if (numero != null && numero.length() <= LastDigitsLenght) {
      return numero;
    }
    return numero.substring(numero.length() - LastDigitsLenght);
  }

  public Boolean isValid() {
    LocalDate today = LocalDate.now();
    LocalDate endOfMonthDay = null;
    if (dataValidade != null) {
      endOfMonthDay = dataValidade.atEndOfMonth();
      return !today.isAfter(endOfMonthDay);
    }
    return false;
  }

  @Override
  public String toString() {
    return "DADOS DESTE CARTÃO - TITULAR=" + nomeUsuario + ", NÚMERO=XXXX-XXXX-XXXX-" + ultimosQuatroDigitos()
        + ", VÁLIDO ATÉ=" + dataValidade + ", CVV=XXX";
  }
}
