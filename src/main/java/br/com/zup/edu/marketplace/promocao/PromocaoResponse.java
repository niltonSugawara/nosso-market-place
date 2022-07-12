package br.com.zup.edu.marketplace.promocao;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromocaoResponse {

    private Long id;

    private Long idProduto;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fim;

    private BigDecimal valor;

    private String regras;

    private PromocaoResponse(Long id, Long idProduto, LocalDate inicio,
                            LocalDate fim, BigDecimal valor, String regras) {
        this.id = id;
        this.idProduto = idProduto;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
        this.regras = regras;
    }

    public static PromocaoResponse of(Promocao promocao) {
        return new PromocaoResponse(promocao.getId(),promocao.getProduto().getId(),
                promocao.getInicio(), promocao.getFim(), promocao.getValor(),
                promocao.getRegras());
    }

    public Long getId() {
        return id;
    }

    public Long getIdProduto() {
        return idProduto;
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
