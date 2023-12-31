package ru.misis.webapp.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.webapp.dto.ReverseStringDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.ReverseStringService;

/**
 * MVC контроллер для разворота строки
 *
 * @author Matvey Konovalov
 * @since 28.12.2023
 */
@Controller
public class ReverseStringController {

    private final ReverseStringService service;

    @Autowired
    public ReverseStringController(ReverseStringService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        ReverseStringDto reverseStringDto = (ReverseStringDto) session.getAttribute("reverseStringDto");

        if (reverseStringDto == null) {
            reverseStringDto = new ReverseStringDto();
            session.setAttribute("reverseStringDto", reverseStringDto);
        }

        model.addAttribute("reverseStringDto", reverseStringDto);
        return "index";
    }

    @PostMapping("/reverse")
    public String reverse(@ModelAttribute ReverseStringDto reverseStringDto, HttpSession session) {
        ResultDto resultDto = service.revert(reverseStringDto);

        session.setAttribute("reverseStringDto", reverseStringDto);
        session.setAttribute("result", resultDto.getResult());

        return "redirect:/";
    }
}
