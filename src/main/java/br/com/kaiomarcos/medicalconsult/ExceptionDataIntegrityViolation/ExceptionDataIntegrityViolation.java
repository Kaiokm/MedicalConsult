package br.com.kaiomarcos.medicalconsult.ExceptionDataIntegrityViolation;

public class ExceptionDataIntegrityViolation extends RuntimeException{
    public ExceptionDataIntegrityViolation(String message){
        super(message);
    }

}
