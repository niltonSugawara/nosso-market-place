package br.com.zup.edu.marketplace.promocao;

import br.com.zup.edu.marketplace.produto.Produto;
import br.com.zup.edu.marketplace.produto.ProdutoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromocaoRequest {

    private Long idProduto;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate inicio;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fim;

    private BigDecimal valor;

    private String regras;

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public Promocao toModel(ProdutoRepository produtoRepository) {
        var produto = produtoRepository.findById(this.idProduto)
                .orElseThrow(IllegalArgumentException::new);

        return new Promocao(produto, this.inicio, this.fim, this.valor, this.regras);
    }
}
