package br.com.kaiomarcos.medicalconsult.usuario.service;

import br.com.kaiomarcos.medicalconsult.usuario.domain.Usuario;
import br.com.kaiomarcos.medicalconsult.usuario.repositories.UsuarioRepository;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

     public Usuario cadastrarUsuario(Usuario usuario){
         return usuarioRepository.save(usuario);
     }

     public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado:", id));
     }

     public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuario(id);
        usuarioRepository.delete(usuario);
     }

     public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario upUsuario = buscarUsuario(id);
        upUsuario.setNomeUsuario(usuario.getNomeUsuario());
        upUsuario.setEmail(usuario.getEmail());
        upUsuario.setTelefone(usuario.getTelefone());
        upUsuario.setDataNascimento(usuario.getDataNascimento());
        upUsuario.setPermissao(usuario.getPermissao());
        return usuarioRepository.save(upUsuario);
     }
}
