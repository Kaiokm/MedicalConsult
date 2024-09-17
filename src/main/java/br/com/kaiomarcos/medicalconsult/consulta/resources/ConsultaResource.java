package br.com.kaiomarcos.medicalconsult.consulta.resources;

import br.com.kaiomarcos.medicalconsult.consulta.domain.Consulta;
import br.com.kaiomarcos.medicalconsult.consulta.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(name = "/consultas")
public class ConsultaResource {

    @Autowired
    private ConsultaService consultaService;

    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta){
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }
}
