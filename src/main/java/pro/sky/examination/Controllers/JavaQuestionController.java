package pro.sky.examination.Controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examination.Question;
import pro.sky.examination.Services.JavaQuestionServiceImpl;

import java.util.Collection;

@Qualifier
@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {
    JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/java/add")
    public Question add(@RequestParam("qwestion") String qwestion,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.add(qwestion, answer);
    }

    @GetMapping(path = "/java/remove")
    public Question remove(@RequestParam("qwestion") String qwestion,
                           @RequestParam("answer") String answer) {
        return javaQuestionService.remove(qwestion, answer);
    }

    @GetMapping(path = "/java")
    public Collection<Question> allQwestions() {
        return javaQuestionService.getAll();
    }
}
