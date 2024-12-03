package br.com.kaiomarcos.medicalconsult.consulta.service;

import br.com.kaiomarcos.medicalconsult.ExceptionDataIntegrityViolation.ExceptionDataIntegrityViolation;
import br.com.kaiomarcos.medicalconsult.consulta.domain.Consulta;
import br.com.kaiomarcos.medicalconsult.consulta.repositories.ConsultaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta buscarConsulta(Long id){
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.orElseThrow(() -> new ObjectNotFoundException("Especialidade não encontrada! ID:", id));
    }

    public Consulta atualizarConsulta(Consulta consulta){
        Consulta novaConstulta = buscarConsulta(consulta.getIdConsulta());
        updateData(novaConstulta, consulta);
        return consultaRepository.save(novaConstulta);
    }

    public void deletarConsulta(Long id){
        buscarConsulta(id);
        try {
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolation("Não é possivel excluir, porque há entidades relacionados.");
        }
    }

    private void updateData(Consulta novaConsulta, Consulta consulta){
        novaConsulta.setDataConsulta(consulta.getDataConsulta());
        novaConsulta.setProfissional(consulta.getProfissional());
        novaConsulta.setEspecialidade(consulta.getEspecialidade());
    }
}
