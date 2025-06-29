package me.leejunseok;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class maincontroller {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userInput", new UserInput());
        return "index";
    }

    @PostMapping("/submitFirst")
    public String submitFirst(@ModelAttribute UserInput input, @RequestParam("action") String action) {
        System.out.println("[1번] 이름: " + input.getName() + ", ChatID: " + input.getChatId());
        System.out.println("→ 버튼 타입: " + action);
        return "redirect:/";
    }

    @PostMapping("/submitSecond")
    public String submitSecond(@ModelAttribute UserInput input, @RequestParam("action") String action) {
        System.out.println("[2번] 기준: " + input.getBasicMetric() + ", 수치: " + input.getBasicValue());
        System.out.println("→ 버튼 타입: " + action);
        return "redirect:/";
    }

    @PostMapping("/submitThird")
    public String submitThird(@ModelAttribute UserInput input, @RequestParam("action") String action) {
        System.out.println("[3번] 지표: " + input.getTechMetric() + ", 주기: " + input.getTerm()
                + ", 일 수: " + input.getDays() + ", 수치: " + input.getTechValue());
        System.out.println("→ 버튼 타입: " + action);
        return "redirect:/";
    }
}