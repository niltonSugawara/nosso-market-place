package br.com.zup.edu.marketplace.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProdutoResponse incluir(@RequestBody ProdutoRequest request){
        var produto = request.toModel();

        produtoRepository.save(produto);

        return ProdutoResponse.of(produto);
    }


}
