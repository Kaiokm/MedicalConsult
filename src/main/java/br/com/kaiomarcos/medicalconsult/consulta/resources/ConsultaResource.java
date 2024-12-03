package br.com.kaiomarcos.medicalconsult.consulta.resources;

import br.com.kaiomarcos.medicalconsult.consulta.domain.Consulta;
import br.com.kaiomarcos.medicalconsult.consulta.service.ConsultaService;
import br.com.kaiomarcos.medicalconsult.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/consultas")
public class ConsultaResource {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta){
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consulta> listarConsultas(@PathVariable Long id){
        Consulta consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }

    @GetMapping
    public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id){
        Consulta consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok().body(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta, @PathVariable Long id){
        consulta.setIdConsulta(id);
        Consulta consultaAtualiza = consultaService.atualizarConsulta(consulta);
        return ResponseEntity.ok().body(consultaAtualiza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id){
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
