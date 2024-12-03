package br.com.kaiomarcos.medicalconsult.usuario.domain;

import br.com.kaiomarcos.medicalconsult.consulta.domain.Consulta;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "USUARIOS")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "PERMISSAO")
    @Enumerated(EnumType.STRING)
    private Permissao permissao;

//    private permissao permissao;


    public Usuario(Long idUsuario, String nomeUsuario, String email, String cpf, String telefone, Date dataNascimento) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.permissao = permissao;
    }
    public Usuario() {
    }


}
