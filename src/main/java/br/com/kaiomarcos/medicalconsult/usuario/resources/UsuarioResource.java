package br.com.kaiomarcos.medicalconsult.usuario.resources;

import br.com.kaiomarcos.medicalconsult.usuario.domain.Usuario;
import br.com.kaiomarcos.medicalconsult.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> busacarCliente(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> ListarClientes(){
        List<Usuario> usuarios = usuarioService.listarUsuario();
        return ResponseEntity.ok().body(usuarios);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Usuario> atualizarCliente(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario upCliente = usuarioService.atualizarUsuario(id,usuario);
        return ResponseEntity.ok().body(upCliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
