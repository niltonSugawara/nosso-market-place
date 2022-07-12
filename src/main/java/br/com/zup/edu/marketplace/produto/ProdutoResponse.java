package br.com.zup.edu.marketplace.produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private BigDecimal preco;

    private ProdutoResponse(Long id, String titulo, String descricao, BigDecimal preco) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public static ProdutoResponse of(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getTitulo(),
                produto.getDescricao(), produto.getPreco());
    }
}
