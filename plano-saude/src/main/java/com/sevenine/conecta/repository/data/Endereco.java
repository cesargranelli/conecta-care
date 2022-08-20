package com.sevenine.conecta.repository.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @Column(name = "plano_saude_id")
    private Long idPlanoSaude;

    @Column(name = "logradouro", length = 60)
    private String logradouro;

    @Column(name = "numero", length = 10)
    private int numero;

    @Column(name = "complemento", length = 60)
    private String complemento;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "comprovante", length = 255)
    private String comprovante;

    public void atualizarEndereco(Endereco novoEndereco) {
        setLogradouro(novoEndereco.getLogradouro());
        setNumero(novoEndereco.getNumero());
        setComplemento(novoEndereco.getComplemento());
        setBairro(novoEndereco.getBairro());
        setCep(novoEndereco.getCep());
        setCidade(novoEndereco.getCidade());
        setEstado(Estado.builder().id(novoEndereco.getEstado().getId()).build());
        setPais(Pais.builder().id(novoEndereco.getPais().getId()).build());
        setComprovante(novoEndereco.getComprovante());
    }

}
