package ru.misis.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO результата вычислений
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Data
@AllArgsConstructor
public class ResultDto {

    private Double result;
}
