package pro.sky.examination.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examination.Interfaces.ExaminerService;
import pro.sky.examination.Question;

import java.util.Collection;

@RestController

public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/exam/get/{amount}")
    public Collection<Question> getAllQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
