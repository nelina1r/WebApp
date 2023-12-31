package ru.misis.webapp.controller.mvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.webapp.dto.CalculatorDataDto;
import ru.misis.webapp.dto.ResultDto;
import ru.misis.webapp.service.CalculatorService;

/**
 * MVC контроллер для калькулятора
 *
 * @author Alexander Dedov
 * @since 28.12.2023
 */
@Controller
public class CalculatorController {

    private final CalculatorService service;

    @Autowired
    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        CalculatorDataDto calculatorData = (CalculatorDataDto) session.getAttribute("calculatorData");

        if (calculatorData == null) {
            calculatorData = new CalculatorDataDto();
            session.setAttribute("calculatorData", calculatorData);
        }

        model.addAttribute("calculatorData", calculatorData);
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute CalculatorDataDto calculatorData, Model model, HttpSession session) {
        ResultDto resultDto = service.calculate(calculatorData);

        session.setAttribute("calculatorData", calculatorData);
        session.setAttribute("result", resultDto.getResult());

        return "redirect:/";
    }
}
