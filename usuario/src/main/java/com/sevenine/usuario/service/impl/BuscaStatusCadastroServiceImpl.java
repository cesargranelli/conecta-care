//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.enumerator.StatusCadastro;
//import com.sevenine.usuario.repository.data.SequenceCadastro;
//import com.sevenine.usuario.repository.data.Usuario;
//import com.sevenine.usuario.services.BuscaStatusCadastroService;
//import com.sevenine.usuario.services.ConsultaUsuarioService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@RequiredArgsConstructor
//@Component
//public class BuscaStatusCadastroServiceImpl implements BuscaStatusCadastroService {
//
//    private final ConsultaUsuarioService consultaUsuarioService;
//
//    @Override
//    public StatusCadastro validar(String email, String modulo) {
//        Usuario usuario = consultaUsuarioService.buscarUsuario(email);
//        return usuario.getDocumentoUsuario().stream()
//                .filter(documentoUsuario -> documentoUsuario.getModulo().name().equals(modulo))
//                .findFirst().orElse(SequenceCadastro.builder()
//                        .status(StatusCadastro.INCOMPLETO)
//                        .build()).getStatus();
//    }
//
//}
