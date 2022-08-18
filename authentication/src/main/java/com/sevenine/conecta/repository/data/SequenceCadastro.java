package com.sevenine.conecta.repository.data;

import com.sevenine.conecta.enumerator.Modulo;
import com.sevenine.conecta.enumerator.StatusCadastro;
import com.sevenine.conecta.enumerator.TipoDocumento;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sequences_cadastro")
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class SequenceCadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 25)
    private StatusCadastro status;

    @Column(name = "documento", length = 15)
    private String documento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoDocumento tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "modulo")
    private Modulo modulo;

}
