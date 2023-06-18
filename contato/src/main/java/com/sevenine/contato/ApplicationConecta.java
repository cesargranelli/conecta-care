package com.sevenine.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/service-contato/v1/cadastro")
@RestController
@SpringBootApplication
public class ApplicationConecta {

    @Autowired
    private ContatoCollectionRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConecta.class, args);
    }

    @PostMapping
    public void cadastro(@RequestBody Object request) {
        System.out.println(request);

        System.out.printf("Quantidade contatos: %s", repository.count().block());
    }

}
