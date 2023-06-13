//package com.sevenine.usuario.repository.data;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "usuarios")
//public class Usuario {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String email;
//
//    private String password;
//
//    private String roles;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "sequences_cadastro_usuarios",
//            joinColumns = @JoinColumn(name = "id_usuario"),
//            inverseJoinColumns = @JoinColumn(name = "id_sequence_cadastro")
//    )
//    private List<SequenceCadastro> documentoUsuario;
//
//}
