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

    @Column(name = "homecare_id")
    private Long idHomecare;

    @Column(name = "telefone_fixo", length = 13)
    private String telefoneFixo;

    @Column(name = "telefone_recado", length = 13)
    private String telefoneRecado;

    @Column(name = "telefone_celular", length = 13)
    private String telefoneCelular;

    @Column(name = "telefone_whatsapp", length = 13)
    private String telefoneWhatsapp;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "flag_aceite_declaracao", length = 3)
    private String flagAceiteDeclaracao;

    @Column(name = "flag_aceite_privacidade", length = 3)
    private String flagAceitePrivacidade;

    public void atualizarContato(Contato novoContato) {
        setTelefoneFixo(novoContato.getTelefoneFixo());
        setTelefoneRecado(novoContato.getTelefoneRecado());
        setTelefoneCelular(novoContato.getTelefoneCelular());
        setTelefoneWhatsapp(novoContato.getTelefoneWhatsapp());
        setEmail(novoContato.getEmail());
        setFlagAceiteDeclaracao(novoContato.getFlagAceiteDeclaracao());
        if (!isNull(novoContato.getFlagAceitePrivacidade())) {
            setFlagAceitePrivacidade(novoContato.getFlagAceitePrivacidade());
        }
    }

}
