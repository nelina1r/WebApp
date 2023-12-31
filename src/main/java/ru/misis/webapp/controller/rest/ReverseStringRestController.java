package ru.misis.webapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.misis.webapp.dto.ReverseStringDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.ReverseStringService;

/**
 * REST контроллер для разворота строки
 *
 * @author Matvey Konovalov
 * @since 28.12.2023
 */
@RestController
@RequestMapping("/api/dev")
public class ReverseStringRestController {

    private final ReverseStringService service;

    @Autowired
    public ReverseStringRestController(ReverseStringService service) {
        this.service = service;
    }

    @PostMapping("/reverse")
    public ResponseEntity<ResultDto> reverse(@RequestBody ReverseStringDto reverseStringDto) {
        ResultDto resultDto = service.revert(reverseStringDto);

        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
}
