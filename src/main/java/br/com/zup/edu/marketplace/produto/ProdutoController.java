package br.com.zup.edu.marketplace.produto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(ProdutoController.class);
    @Autowired
    public ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProdutoResponse incluir(@RequestBody ProdutoRequest request){
        var produto = request.toModel();

        produtoRepository.save(produto);

        logger.info("Produto {} cadastrado com sucesso! ",produto.getTitulo());

        return ProdutoResponse.of(produto);
    }


}
