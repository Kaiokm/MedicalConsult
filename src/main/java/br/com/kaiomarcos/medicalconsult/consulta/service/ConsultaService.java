package br.com.kaiomarcos.medicalconsult.consulta.service;

import br.com.kaiomarcos.medicalconsult.consulta.domain.Consulta;
import br.com.kaiomarcos.medicalconsult.consulta.repositories.ConsultaRepository;

public class ConsultaService {

    private ConsultaRepository consultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }
}
