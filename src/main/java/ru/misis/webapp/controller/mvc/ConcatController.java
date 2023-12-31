package ru.misis.webapp.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.webapp.dto.ConcatDataDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.ConcatService;

/**
 * MVC контроллер для конкатенации
 *
 * @author Anton Loyko
 * @since 28.12.2023
 */
@Controller
public class ConcatController {

    private final ConcatService service;

    @Autowired
    public ConcatController(ConcatService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        ConcatDataDto concatData = (ConcatDataDto) session.getAttribute("concatData");

        if (concatData == null) {
            concatData = new ConcatDataDto();
            session.setAttribute("concatData", concatData);
        }

        model.addAttribute("concatData", concatData);
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute ConcatDataDto concatData, HttpSession session) {
        ResultDto resultDto = service.concat(concatData);

        session.setAttribute("concatData", concatData);
        session.setAttribute("result", resultDto.getResult());

        return "redirect:/";
    }
}
