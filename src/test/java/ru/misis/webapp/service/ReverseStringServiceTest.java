package ru.misis.webapp.service;

import org.junit.jupiter.api.Test;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.dto.ReverseStringDto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Тесты для {@link ReverseStringService}
 *
 * @author Matvey Konovalov
 * @since 31.12.2023
 */
class ReverseStringServiceTest {

    /**
     * Тестирование сценария, когда текст не является null.
     */
    @Test
    void revertWithNonNullText() {
        ReverseStringDto reverseStringDto = new ReverseStringDto();
        reverseStringDto.setText("Hello");

        ResultDto resultDto = new ReverseStringService().revert(reverseStringDto);

        assertEquals("olleH", resultDto.getResult());
    }

    /**
     * Тестирование сценария, когда текст равен null.
     */
    @Test
    void revertWithNullText() {
        ReverseStringDto reverseStringDto = new ReverseStringDto();
        reverseStringDto.setText(null);

        ResultDto resultDto = new ReverseStringService().revert(reverseStringDto);

        assertNull(resultDto.getResult());
    }

    /**
     * Тестирование сценария, когда текст является пустой строкой.
     */
    @Test
    void revertWithEmptyText() {
        ReverseStringDto reverseStringDto = new ReverseStringDto();
        reverseStringDto.setText("");

        ResultDto resultDto = new ReverseStringService().revert(reverseStringDto);

        assertEquals("", resultDto.getResult());
    }
}