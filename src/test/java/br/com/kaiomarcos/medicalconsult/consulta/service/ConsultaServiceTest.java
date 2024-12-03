package br.com.kaiomarcos.medicalconsult.consulta.service;

import br.com.kaiomarcos.medicalconsult.usuario.domain.Usuario;
import br.com.kaiomarcos.medicalconsult.usuario.repositories.UsuarioRepository;
import br.com.kaiomarcos.medicalconsult.usuario.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class ConsultaServiceTest {

        @Mock
        private UsuarioRepository usuarioRepository; // Supondo que use um repositório de Usuário

        @InjectMocks
        private UsuarioService usuarioService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testCadastrarUsuario() {
            Usuario usuario = new Usuario();
            when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

            Usuario usuarioSalvo = usuarioService.cadastrarUsuario(usuario);

            assertNotNull(usuarioSalvo);
            assertEquals("João Silva", usuarioSalvo.getNomeUsuario());
            verify(usuarioRepository, times(1)).save(usuario);
        }

        @Test
        void testBuscarUsuarioPorId() {
            Usuario usuario = new Usuario();
            when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

            Usuario usuarioEncontrado = usuarioService.buscarUsuario(1L);

            assertNotNull(usuarioEncontrado);
            assertEquals("João Silva", usuarioEncontrado.getNomeUsuario());
            verify(usuarioRepository, times(1)).findById(1L);
        }

        @Test
        void testAtualizarUsuario() {
            Usuario usuario = new Usuario();
            when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

            Usuario usuarioAtualizado = usuarioService.atualizarUsuario(usuario);

            assertNotNull(usuarioAtualizado);
            assertEquals("João Silva", usuarioAtualizado.getNomeUsuario());
            verify(usuarioRepository, times(1)).save(usuario);
        }

        @Test
        void testDeletarUsuario() {
            Long userId = 1L;

            usuarioService.deletarUsuario(userId);

            verify(usuarioRepository, times(1)).deleteById(userId);
        }
}