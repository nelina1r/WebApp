package ru.misis.webapp.dto;

import lombok.Data;

/**
 * DTO с полями для конкатенации
 *
 * @author Anton Loyko
 * @since 28.12.2023
 */
@Data
public class ConcatDataDto {

    private String firstString;

    private String secondString;

    private String thirdString;
}
