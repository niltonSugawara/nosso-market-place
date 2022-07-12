package br.com.zup.edu.marketplace.produto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotNull
    private String titulo;

    private String descricao;

    private BigDecimal preco;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto toModel() {
        return new Produto(this.titulo, this.descricao, this.preco);
    }
}
