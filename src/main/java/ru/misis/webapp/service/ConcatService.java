package ru.misis.webapp.service;

import org.apache.commons.text.CaseUtils;
import org.springframework.stereotype.Service;
import ru.misis.webapp.dto.ConcatDataDto;
import ru.misis.webapp.dto.ResultDto;

/**
 * Сервис с функционалом конкатенации
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Service
public class ConcatService {

    public ResultDto concat(ConcatDataDto concatData){
        StringBuilder result = new StringBuilder();
        if (concatData.getFirstString() != null){
            result.append(CaseUtils.toCamelCase(concatData.getFirstString(), true))
                    .append(" ");
        }
        if (concatData.getSecondString() != null){
            result.append(CaseUtils.toCamelCase(concatData.getSecondString(), true))
                    .append(" ");
        }
        if (concatData.getThirdString() != null){
            result.append(CaseUtils.toCamelCase(concatData.getThirdString(), true));
        }
        return new ResultDto(result.toString());
    }
}
