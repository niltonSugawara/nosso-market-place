package br.com.zup.edu.marketplace.promocao;

import br.com.zup.edu.marketplace.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {

    @Autowired
    public PromocaoRepository promocaoRepository;

    @Autowired
    public ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PromocaoResponse incluir(@RequestBody PromocaoRequest promocaoRequest){

        var promocao = promocaoRequest.toModel(produtoRepository);

        promocaoRepository.save(promocao);

        return PromocaoResponse.of(promocao);
    }
}
