package com.sevenine.conecta.repository.data;

import lombok.*;

import javax.persistence.*;

import static java.util.Objects.isNull;

@Entity
@Table(name = "contatos")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plano_saude_id")
    private Long idPlanoSaude;

    @Column(name = "telefone_fixo", length = 13)
    private String telefoneFixo;

    @Column(name = "telefone_recado", length = 13)
    private String telefoneRecado;

    @Column(name = "telefone_celular", length = 13)
    private String telefoneCelular;

    @Column(name = "telefone_whatsapp", length = 13)
    private String telefoneWhatsapp;

    @Column(name = "telefone_ouvidoria", length = 13)
    private String telefoneOuvidoria;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "site", length = 100)
    private String site;

    @Column(name = "flag_aceite_declaracao", length = 3)
    private String flagAceiteDeclaracao;

    @Column(name = "flag_aceite_privacidade", length = 3)
    private String flagAceitePrivacidade;

    public void atualizarContato(Contato novoContato) {
        setTelefoneFixo(novoContato.getTelefoneFixo());
        setTelefoneRecado(novoContato.getTelefoneRecado());
        setTelefoneCelular(novoContato.getTelefoneCelular());
        setTelefoneWhatsapp(novoContato.getTelefoneWhatsapp());
        setTelefoneOuvidoria(novoContato.getTelefoneOuvidoria());
        setEmail(novoContato.getEmail());
        setSite(novoContato.getSite());
        setFlagAceiteDeclaracao(novoContato.getFlagAceiteDeclaracao());
        if (!isNull(novoContato.getFlagAceitePrivacidade())) {
            setFlagAceitePrivacidade(novoContato.getFlagAceitePrivacidade());
        }
    }

}
