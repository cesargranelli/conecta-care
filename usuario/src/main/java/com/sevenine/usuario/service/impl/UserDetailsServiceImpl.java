//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
//import com.sevenine.usuario.repository.UsuarioRepository;
//import com.sevenine.usuario.repository.data.Usuario;
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//import static com.sevenine.usuario.utils.converter.RoleConverter.rolesStringToRolesList;
//
//@RequiredArgsConstructor
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UsuarioRepository repository;
//    private final Converter<CadastroUsuarioRequest, Usuario> usuarioRequestConverter;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Usuario usuario = repository.findByEmail(email).orElse(null);
//        if (Objects.isNull(usuario)) {
//            throw new UsernameNotFoundException(email);
//        }
//        return new User(usuario.getEmail(), usuario.getPassword(), rolesStringToRolesList(usuario.getRoles()));
//    }
//
//}
