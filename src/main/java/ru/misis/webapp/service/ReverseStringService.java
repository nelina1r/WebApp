package ru.misis.webapp.service;

import org.springframework.stereotype.Service;
import ru.misis.webapp.dto.ReverseStringDto;
import ru.misis.webapp.dto.ResultDto;

/**
 * Сервис с функционалом разворота строки
 *
 * @author Matvey Konovalov
 * @since 28.12.2023
 */
@Service
public class ReverseStringService {

    public ResultDto revert(ReverseStringDto reverseStringDto){
        if (reverseStringDto.getText() != null){
            return new ResultDto(new StringBuilder(reverseStringDto.getText()).reverse().toString());
        }
        return new ResultDto(null);
    }
}
