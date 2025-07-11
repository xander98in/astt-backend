package com.unicuaca.asst.unicauca_asst.core.batteries_management.application.dto.request;

import com.unicuaca.asst.unicauca_asst.common.validation.FirstGroup;
import com.unicuaca.asst.unicauca_asst.common.validation.SecondGroup;
import com.unicuaca.asst.unicauca_asst.core.batteries_management.infrastructure.adapters.input.validation.ValidBirthYear;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la creación de una persona evaluada.
 * 
 * Contiene los datos básicos requeridos para registrar a una persona en el sistema de baterías de riesgo psicosocial,
 * incluyendo validaciones de formato y obligatoriedad.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@GroupSequence({FirstGroup.class, SecondGroup.class, PersonEvaluatedCreateRequestDTO.class})
public class PersonEvaluatedCreateRequestDTO {

    /**
     * Número de identificación de la persona (único).
     */
    @NotBlank(message = "{person.identificationNumber.notBlank}", groups = FirstGroup.class)
    @Size(min = 6, max = 20, message = "{person.identificationNumber.size}", groups = SecondGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "{person.identificationNumber.pattern}", groups = SecondGroup.class)
    @Pattern(regexp = "^[^\s].*[^\s]$", message = "{person.identificationNumber.noTrailingSpaces}", groups = SecondGroup.class)
    private String identificationNumber;

    /**
     * Nombres de la persona.
     */
    @NotBlank(message = "{person.firstName.notBlank}", groups = FirstGroup.class)
    @Size(min = 1, max = 80, message = "{person.firstName.size}", groups = SecondGroup.class)
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 ]+$", message = "{person.firstName.pattern}", groups = SecondGroup.class)
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$).*", message = "{person.firstName.noTrailingSpaces}", groups = SecondGroup.class)
    private String firstName;

    /**
     * Apellidos de la persona.
     */
    @NotBlank(message = "{person.lastName.notBlank}", groups = FirstGroup.class)
    @Size(min = 1, max = 80, message = "{person.lastName.size}", groups = SecondGroup.class)
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 ]+$", message = "{person.lastName.pattern}", groups = SecondGroup.class)
    @Pattern(regexp = "^(?!\\s)(?!.*\\s$).*", message = "{person.lastName.noTrailingSpaces}", groups = SecondGroup.class)
    private String lastName;

    /**
     * Año de nacimiento de la persona.
     */
    @NotNull(message = "{person.birthYear.notNull}")
    @ValidBirthYear
    private Integer birthYear;

    /**
     * Correo electrónico de la persona.
     */
    @NotBlank(message = "{person.email.notBlank}", groups = FirstGroup.class)
    @Size(min = 10, max = 100, message = "{person.email.size}", groups = SecondGroup.class)
    @Pattern(
        regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
        message = "{person.email.pattern}",
        groups = SecondGroup.class
    )
    @Pattern(regexp = "^[^\s].*[^\s]$", message = "{person.email.noTrailingSpaces}", groups = SecondGroup.class)
    private String email;

    /**
     * ID del tipo de identificación seleccionado (ej: 1 para Cédula, 2 para Pasaporte...).
     */
    @NotNull(message = "{person.identificationTypeId.notNull}", groups = FirstGroup.class)
    private Long identificationTypeId;
    /**
     * ID del género seleccionado (ej: 1 para Masculino, 2 para Femenino...).
     */
    @NotNull(message = "{person.genderId.notNull}", groups = FirstGroup.class)
    private Long genderId;
}