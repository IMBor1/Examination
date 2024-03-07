//package pro.sky.examination.Services;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.SessionScope;
//import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
//import pro.sky.examination.Exceptions.QuestionNotFoundException;
//import pro.sky.examination.Interfaces.QuestionService;
//import pro.sky.examination.Question;
//
//import java.util.*;
//
//@SessionScope
//
//@Service
//public class MathQuestionService implements QuestionService {
//    private final Set<Question> mathQuestions;
//
//    public MathQuestionService(Set<Question> mathQuestions) {
//        this.mathQuestions = mathQuestions;
//    }
//
//    @Override
//    public Question add(String question, String answer) {
//        Question newQuestion = new Question(question, answer);
//        if (mathQuestions.contains(newQuestion)) {
//            throw new QuestionIsAlreadyCreatedException("такой вопрос уже существует");
//        }
//        mathQuestions.add(newQuestion);
//        return newQuestion;
//    }
//
//    @Override
//    public Question add(Question question) {
//        if (mathQuestions.contains(question)) {
//            throw new QuestionIsAlreadyCreatedException();
//        }
//        mathQuestions.add(question);
//        return question;
//    }
//
//    @Override
//    public Question remove(String question, String answer) {
//        Question question1 = new Question(question, answer);
//        if (mathQuestions.contains(question1)) {
//
//            mathQuestions.remove(question1);
//            return question1;
//        }
//        throw new QuestionNotFoundException("такой вопрос не найден");
//    }
//
//    @Override
//    public Set<Question> getAll() {
//        Set<Question> questionSet = new HashSet<>(mathQuestions);
//        return questionSet;
//    }
//
//    @Override
//    public Question getRandomQuestion() {
//        Random r = new Random();
//        int random = r.nextInt(mathQuestions.size());
//        List<Question> list = new ArrayList<>(mathQuestions);
//        return list.get(random);
//
//    }
//}
//
//
