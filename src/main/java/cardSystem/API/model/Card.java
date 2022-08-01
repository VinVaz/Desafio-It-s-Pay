package cardSystem.API.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import lombok.NoArgsConstructor;

@Entity(name = "Card")
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
  private String dataValidade;

  public static final String DATA_VALIDADE_FORMATO = "mm/yyyy";

  public Card(String numero, String nomeUsuario, String codigoSeguranca, String dataValidade) {
    this.numero = numero;
    this.nomeUsuario = nomeUsuario;
    this.codigoSeguranca = codigoSeguranca;
    this.dataValidade = dataValidade;
  }

  public String getDataValidade() {
    return dataValidade;
  }

  public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
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
    if (numero != null) {
      if (numero.length() <= LastDigitsLenght) {
        return numero;
      }
      return numero.substring(numero.length() - LastDigitsLenght);
    }
    return "";
  }

  @Override
  public String toString() {
    return "Card [id=" + id + ", numero=" + numero + ", nomeUsuario=" + nomeUsuario + ", codigoSeguranca="
        + codigoSeguranca + ", dataValidade=" + dataValidade + "]";
  }
}
