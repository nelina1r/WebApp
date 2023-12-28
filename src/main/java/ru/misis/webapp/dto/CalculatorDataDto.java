package ru.misis.webapp.dto;

import lombok.Data;

/**
 * DTO с полями для калькуляции
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Data
public class CalculatorDataDto {

    private Double firstNumber;

    private String operand;

    private Double secondNumber;
}
