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
public class EnderecoHomecare {

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

    @Column(name = "homecare_id")
    private Long homecareId;

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

    public void atualizarEndereco(EnderecoHomecare novoEnderecoHomecare) {
        setLogradouro(novoEnderecoHomecare.getLogradouro());
        setNumero(novoEnderecoHomecare.getNumero());
        setComplemento(novoEnderecoHomecare.getComplemento());
        setBairro(novoEnderecoHomecare.getBairro());
        setCep(novoEnderecoHomecare.getCep());
        setCidade(novoEnderecoHomecare.getCidade());
        setEstado(Estado.builder().id(novoEnderecoHomecare.getEstado().getId()).build());
        setPais(Pais.builder().id(novoEnderecoHomecare.getPais().getId()).build());
        setComprovante(novoEnderecoHomecare.getComprovante());
    }

}
