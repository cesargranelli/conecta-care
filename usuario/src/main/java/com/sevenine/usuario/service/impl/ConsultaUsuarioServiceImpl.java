//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.repository.UsuarioRepository;
//import com.sevenine.usuario.repository.data.Usuario;
//import com.sevenine.usuario.services.ConsultaUsuarioService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class ConsultaUsuarioServiceImpl implements ConsultaUsuarioService {
//
//    private final UsuarioRepository repository;
//
//    @Override
//    public Usuario buscarUsuario(String email) {
//        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
//    }
//
//}
