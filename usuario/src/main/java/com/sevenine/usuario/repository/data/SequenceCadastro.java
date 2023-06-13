//package com.sevenine.usuario.repository.data;
//
//import com.sevenine.usuario.enumerator.Modulo;
//import com.sevenine.usuario.enumerator.StatusCadastro;
//import com.sevenine.usuario.enumerator.TipoDocumento;
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "sequences_cadastro")
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//public class SequenceCadastro {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status", length = 25)
//    private StatusCadastro status;
//
//    @Column(name = "documento", length = 15)
//    private String documento;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "tipo")
//    private TipoDocumento tipo;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "modulo")
//    private Modulo modulo;
//
//}
