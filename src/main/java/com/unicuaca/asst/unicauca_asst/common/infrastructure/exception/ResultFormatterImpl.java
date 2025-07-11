package com.unicuaca.asst.unicauca_asst.common.infrastructure.exception;

import org.springframework.stereotype.Service;

import com.unicuaca.asst.unicauca_asst.common.application.output.ResultFormatterOutputPort;
import com.unicuaca.asst.unicauca_asst.common.exceptions.EntityAlreadyExistsException;
import com.unicuaca.asst.unicauca_asst.common.exceptions.EntityCreationException;
import com.unicuaca.asst.unicauca_asst.common.exceptions.EntityNotFoundPersException;
import com.unicuaca.asst.unicauca_asst.common.exceptions.structure.ErrorCode;


/**
 * Implementación del puerto de salida {@link ResultFormatterOutputPort} encargado de lanzar
 * excepciones personalizadas relacionadas con errores de negocio.
 * 
 * Esta clase actúa como adaptador de salida en la arquitectura hexagonal y centraliza el
 * lanzamiento de excepciones para casos como entidades no encontradas, entidades duplicadas
 * o violaciones de reglas de negocio. Su uso permite desacoplar la lógica de dominio de los
 * detalles técnicos relacionados con el manejo de errores.
 * 
 * <p>Se encuentra en el módulo <code>common.infrastructure</code> para ser reutilizada desde
 * cualquier dominio.</p>
 */
@Service
public class ResultFormatterImpl implements ResultFormatterOutputPort{

    /**
     * Lanza una excepción cuando se detecta que una entidad ya existe en el sistema.
     *
     * @param message mensaje explicativo del error
     */
    @Override
    public void throwEntityAlreadyExists(String message) {
        throw new EntityAlreadyExistsException(message);
    }

    /**
     * Lanza una excepción con código específico cuando se detecta una entidad duplicada.
     *
     * @param errorCode código estructurado del error
     * @param message mensaje explicativo del conflicto
     */
    @Override
    public void throwEntityAlreadyExists(ErrorCode errorCode, String message) {
        throw new EntityAlreadyExistsException(errorCode, message);
    }

    /**
     * Lanza una excepción cuando no se encuentra una entidad esperada.
     *
     * @param message mensaje explicativo del error
     */
    @Override
    public void throwEntityNotFound(String message) {
        throw new EntityNotFoundPersException(message);
    }

    /**
     * Lanza una excepción cuando se viola una regla de negocio del sistema.
     *
     * @param message mensaje explicativo del error
     */
    @Override
    public void throwBusinessRuleViolation(String message) {
        throw new UnsupportedOperationException("Unimplemented method 'throwBusinessRuleViolation'");
    }

    /**
     * Lanza una excepción cuando ocurre un fallo en la creación de una entidad.
     *
     * @param message mensaje que describe el fallo
     */
    @Override
    public void throwEntityCreationFailed(String message) {
        throw new EntityCreationException(message);
    }
}
