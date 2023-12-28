package ru.misis.webapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.misis.webapp.dto.CalculatorDataDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.CalculatorService;

/**
 * REST контроллер для калькулятора
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@RestController
@RequestMapping("/api")
public class RestControllerCalculator {

    private final CalculatorService service;

    @Autowired
    public RestControllerCalculator(CalculatorService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ResultDto> calculate(@RequestBody CalculatorDataDto calculatorData) {
        ResultDto resultDto = service.calculate(calculatorData);

        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
}
