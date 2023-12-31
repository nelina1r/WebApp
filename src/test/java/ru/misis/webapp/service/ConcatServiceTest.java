package ru.misis.webapp.service;

import org.junit.jupiter.api.Test;
import ru.misis.webapp.dto.ConcatDataDto;
import ru.misis.webapp.dto.ResultDto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты для {@link ConcatService}
 *
 * @author Anton Loyko
 * @since 31.12.2023
 */
class ConcatServiceTest {

    /**
     * Тестирование сценария, когда все строки заполнены.
     */
    @Test
    void concatWithAllStrings() {
        ConcatDataDto concatData = new ConcatDataDto();
        concatData.setFirstString("first");
        concatData.setSecondString("second");
        concatData.setThirdString("third");

        ResultDto resultDto = new ConcatService().concat(concatData);

        assertEquals("First Second Third", resultDto.getResult());
    }

    /**
     * Тестирование сценария, когда все строки равны null.
     */
    @Test
    void concatWithNullStrings() {
        ConcatDataDto concatData = new ConcatDataDto();

        ResultDto resultDto = new ConcatService().concat(concatData);

        assertEquals("", resultDto.getResult());
    }

    /**
     * Тестирование сценария, когда некоторые строки равны null.
     */
    @Test
    void concatWithSomeNullStrings() {
        ConcatDataDto concatData = new ConcatDataDto();
        concatData.setFirstString("first");
        concatData.setThirdString("third");

        ResultDto resultDto = new ConcatService().concat(concatData);

        assertEquals("First Third", resultDto.getResult());
    }

    /**
     * Тестирование сценария, когда все строки пусты.
     */
    @Test
    void concatWithEmptyStrings() {
        ConcatDataDto concatData = new ConcatDataDto();
        concatData.setFirstString("");
        concatData.setSecondString("");
        concatData.setThirdString("");

        ResultDto resultDto = new ConcatService().concat(concatData);

        assertEquals("  ", resultDto.getResult());
    }
}