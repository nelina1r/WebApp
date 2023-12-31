package ru.misis.webapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.misis.webapp.dto.ConcatDataDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.ConcatService;

/**
 * REST контроллер для конкатенации
 *
 * @author Anton Loyko
 * @since 28.12.2023
 */
@RestController
@RequestMapping("/api/dev")
public class RestConcatController {

    private final ConcatService service;

    @Autowired
    public RestConcatController(ConcatService service) {
        this.service = service;
    }

    @PostMapping("/concat")
    public ResponseEntity<ResultDto> concatStrings(@RequestBody ConcatDataDto concatData) {
        ResultDto resultDto = service.concat(concatData);

        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }
}
