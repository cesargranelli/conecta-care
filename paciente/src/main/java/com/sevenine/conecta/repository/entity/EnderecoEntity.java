package com.sevenine.conecta.repository.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "paciente_id")
    private Long idPaciente;

    @OneToOne
    @JoinColumn(name = "estado_id")
    private EstadoEntity estado;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro", length = 255)
    private String logradouro;

    @Column(name = "numero", length = 10)
    private Integer numero;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "complemento", length = 60)
    private String complemento;

    @Column(name = "comprovante")
    private String fotoComprovante;

}
