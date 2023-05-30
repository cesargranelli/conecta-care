package com.sevenine.conecta.controllers;

import com.sevenine.conecta.adapters.*;
import com.sevenine.conecta.domain.ports.persistences.DominioPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "dominios")
@RestController
public class DominioController {

    @Autowired
    private final List<DominioPersistence<Object, List<?>>> services;

    public DominioController(List<DominioPersistence<Object, List<?>>> services) {
        this.services = services;
    }

    @GetMapping("area-atendimento")
    public List<?> areasAtendimento() {
        return services.stream().filter(AreaAtendimentoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("banco")
    public List<?> bancos() {
        return services.stream().filter(BancoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("categoria-cnh")
    public List<?> categoriasCnh() {
        return services.stream().filter(CategoriaCnhPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("conselho")
    public List<?> conselhos() {
        return services.stream().filter(ConselhoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("estado")
    public List<?> estados() {
        return services.stream().filter(EstadoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("estado-civil")
    public List<?> estadosCivil() {
        return services.stream().filter(EstadoCivilPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("genero")
    public List<?> generos() {
        return services.stream().filter(GeneroPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("grupo")
    public List<?> grupos() {
        return services.stream().filter(GrupoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("instrucao")
    public List<?> instrucoes() {
        return services.stream().filter(InstrucaoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("modelo")
    public List<?> modelos() {
        return services.stream().filter(ModeloPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("pais")
    public List<?> paises() {
        return services.stream().filter(PaisPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("parentesco")
    public List<?> parentescos() {
        return services.stream().filter(ParentescoPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("tipo-conta")
    public List<?> tiposConta() {
        return services.stream().filter(TipoContaPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("tipo-empresa")
    public List<?> tiposEmpresa() {
        return services.stream().filter(TipoEmpresaPersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

    @GetMapping("transporte")
    public List<?> transportes() {
        return services.stream().filter(TransportePersistence.class::isInstance).findAny().orElseThrow()
                .execute();
    }

//    @GetMapping("status-atendimento")
//    public List<?> status() {
//        return services.stream().filter(GeneroPersistence.class::isInstance).findAny().orElseThrow()
//                .execute();
//    }

}

