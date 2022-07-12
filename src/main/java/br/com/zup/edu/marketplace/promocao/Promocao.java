package br.com.zup.edu.marketplace.promocao;

import br.com.zup.edu.marketplace.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private LocalDate inicio;

    private LocalDate fim;

    private BigDecimal valor;

    private String regras;

    @Deprecated
    public Promocao() {
    }

    public Promocao(Produto produto, LocalDate inicio, LocalDate fim, BigDecimal valor, String regras) {
        this.produto = produto;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
        this.regras = regras;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getRegras() {
        return regras;
    }
}
