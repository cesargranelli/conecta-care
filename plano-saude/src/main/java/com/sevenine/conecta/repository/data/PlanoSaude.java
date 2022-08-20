package com.sevenine.conecta.repository.data;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planos_saude")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class PlanoSaude {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_empresa_id")
    private TipoEmpresa tipoEmpresa;

    @OneToMany
    @JoinTable(
            name = "planos_saude_especialidade",
            joinColumns = @JoinColumn(name = "plano_saude_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private List<Especialidade> especialidades;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "ano_fundacao")
    private int anoFundacao;

    @OneToOne
    @JoinTable(
            name = "enderecos",
            joinColumns = @JoinColumn(name = "plano_saude_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Endereco endereco;

    @OneToOne
    @JoinTable(
            name = "contatos",
            joinColumns = @JoinColumn(name = "plano_saude_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Contato contato;

    @ManyToOne
    @JoinColumn(name = "plano_saude_matriz_id")
    private PlanoSaude planoSaudeMatriz;

    public void atualizarPlanoSaude(PlanoSaude novoPlanoSaude) {
        setTipoEmpresa(novoPlanoSaude.getTipoEmpresa());
        setEspecialidades(novoPlanoSaude.getEspecialidades());
        setNome(novoPlanoSaude.getNome());
        setCnpj(novoPlanoSaude.getCnpj());
        setAnoFundacao(novoPlanoSaude.getAnoFundacao());
    }
}
