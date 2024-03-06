//package pro.sky.examination.Controllers;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import pro.sky.examination.Interfaces.QuestionService;
//import pro.sky.examination.Question;
//import pro.sky.examination.Services.JavaQuestionServiceImpl;
//import pro.sky.examination.Services.MathQuestionService;
//
//import java.util.Collection;
//
//    @RestController
//    @RequestMapping(path = "/exam")
//    public class MathQuestionController {
//        MathQuestionService mathQuestionService;
//
//        public MathQuestionController(MathQuestionService mathQuestionService) {
//            this.mathQuestionService = mathQuestionService;
//        }
//
//        @GetMapping(path = "/math/add")
//        public Question add(@RequestParam("question") String question,
//                            @RequestParam("answer") String answer) {
//            return mathQuestionService.add(question, answer);
//        }
//
//        @GetMapping(path = "/math/remove")
//        public Question remove(@RequestParam("question") String question,
//                               @RequestParam("answer") String answer) {
//            return mathQuestionService.remove(question, answer);
//        }
//
//        @GetMapping(path = "/math")
//        public Collection<Question> allQuestions() {
//            return mathQuestionService.getAll();
//        }
//    }
//
//
