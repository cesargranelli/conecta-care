package com.sevenine.conecta.repository.data;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@IdClass(Pk.class)
@Table(name = "sequences_cadastro_usuarios")
public class DocumentoUsuario {

    @Id
    @Column(name = "id_sequence_cadastro")
    private long idSequenceCadastro;

    @Id
    @Column(name = "id_usuario")
    private long idUsuario;

    public Pk getId() {
        return new Pk(idSequenceCadastro, idUsuario);
    }

}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Pk implements Serializable {
    private long idSequenceCadastro;
    private long idUsuario;
}
