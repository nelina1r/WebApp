package ru.misis.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO с полями для калькуляции
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorDataDto {

    private Double firstNumber;

    private String operand;

    private Double secondNumber;
}
