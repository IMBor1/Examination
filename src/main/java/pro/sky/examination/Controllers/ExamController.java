package pro.sky.examination.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examination.Interfaces.ExaminerService;
import pro.sky.examination.Question;

import java.util.Collection;

@RestController

public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "exam/java/allQuestions")
    public Collection<Question> getAllQuestions(@RequestParam("amount") Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
