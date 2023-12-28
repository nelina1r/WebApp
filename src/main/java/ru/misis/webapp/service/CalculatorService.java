package ru.misis.webapp.service;

import org.springframework.stereotype.Service;
import ru.misis.webapp.dto.CalculatorDataDto;
import ru.misis.webapp.dto.ResultDto;

/**
 * Сервис с функционалом калькулятора
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Service
public class CalculatorService {

    public ResultDto calculate(CalculatorDataDto calculatorData){
        if (calculatorData.getOperand().equals("ADD")){
            return new ResultDto(calculatorData.getFirstNumber() + calculatorData.getSecondNumber());
        }
        if (calculatorData.getOperand().equals("SUBTRACT")){
            return new ResultDto(calculatorData.getFirstNumber() - calculatorData.getSecondNumber());
        }
        if (calculatorData.getOperand().equals("MULTIPLY")){
            return new ResultDto(calculatorData.getFirstNumber() * calculatorData.getSecondNumber());
        }
        if (calculatorData.getOperand().equals("DIVIDE")){
            return new ResultDto(calculatorData.getFirstNumber() / calculatorData.getSecondNumber());
        }
        return new ResultDto(null);
    }
}
