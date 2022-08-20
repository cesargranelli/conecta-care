package com.sevenine.conecta.repository.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "homecares")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class HomeCare {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_empresa_id")
    private TipoEmpresa tipoEmpresa;

    @OneToMany
    @JoinTable(
            name = "homecares_especialidade",
            joinColumns = @JoinColumn(name = "homecare_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private List<Especialidade> especialidades;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "site", length = 100)
    private String site;

    @OneToOne
    @JoinTable(
            name = "enderecos",
            joinColumns = @JoinColumn(name = "homecare_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Endereco endereco;

    @OneToOne
    @JoinTable(
            name = "contatos",
            joinColumns = @JoinColumn(name = "homecare_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Contato contato;

    public void atualizarHomeCare(HomeCare novaHomaCare) {
        setTipoEmpresa(novaHomaCare.getTipoEmpresa());
        setEspecialidades(novaHomaCare.getEspecialidades());
        setNome(novaHomaCare.getNome());
        setCnpj(novaHomaCare.getCnpj());
        setSite(novaHomaCare.getSite());
    }
}
