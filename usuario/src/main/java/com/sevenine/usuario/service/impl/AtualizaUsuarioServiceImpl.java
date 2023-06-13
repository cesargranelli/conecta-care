//package com.sevenine.usuario.services.impl;
//
//import com.sevenine.usuario.entity.Role;
//import com.sevenine.usuario.enumerator.StatusCadastro;
//import com.sevenine.usuario.adapter.controller.data.request.CadastroUsuarioRequest;
//import com.sevenine.usuario.repository.UsuarioRepository;
//import com.sevenine.usuario.repository.data.SequenceCadastro;
//import com.sevenine.usuario.repository.data.Usuario;
//import com.sevenine.usuario.services.AtualizaUsuarioService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintViolationException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.sevenine.usuario.utils.converter.RoleConverter.rolesStringToRolesList;
//import static java.util.Objects.requireNonNull;
//
//@RequiredArgsConstructor
//@Component
//public class AtualizaUsuarioServiceImpl implements AtualizaUsuarioService {
//
//    private final UsuarioRepository repository;
//
//    @Override
//    public Usuario atualizar(Usuario usuario, CadastroUsuarioRequest request) {
//        List<Role> roles = rolesStringToRolesList(usuario.getRoles());
//        if (validaStatusCompleto(usuario.getDocumentoUsuario(), request)) {
//            throw new ConstraintViolationException("Usuário já possuí perfil cadastrado para esse módulo", null);
//        } else if (!validaNovoPerfil(roles, request)) {
//            roles.add(new Role(request.getRole()));
//            usuario.setRoles(roles.stream().map(Role::getTipo).collect(Collectors.joining("\",\"", "[\"", "\"]")));
//            return repository.save(requireNonNull(usuario));
//        }
//        return usuario;
//    }
//
//    private boolean validaNovoPerfil(List<Role> roles, CadastroUsuarioRequest request) {
//        return roles.stream().anyMatch(role -> role.getTipo().equals(request.getRole()));
//    }
//
//    private boolean validaStatusCompleto(List<SequenceCadastro> documentoUsuario, CadastroUsuarioRequest request) {
//        return documentoUsuario.stream().anyMatch(sequenceCadastro -> sequenceCadastro.getId().equals(request.getSequence())
//                && sequenceCadastro.getStatus().equals(StatusCadastro.COMPLETO));
//    }
//
//}
