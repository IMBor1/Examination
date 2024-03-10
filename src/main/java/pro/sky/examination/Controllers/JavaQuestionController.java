package pro.sky.examination.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;
import pro.sky.examination.Services.JavaQuestionServiceImpl;

import java.util.Collection;


@RestController

@RequestMapping(path = "/exam/java")
public class JavaQuestionController {


    private final QuestionService questionService;

    public JavaQuestionController(JavaQuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question add(String question,
                        String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(String question,
                           String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping()
    public Collection<Question> allQuestions() {
        return questionService.getAll();
    }
}
