package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Interfaces.QuestionRepository;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;
import pro.sky.examination.Repositories.JavaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service

public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionServiceImpl(JavaRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return questionRepository.addQuestion(question, answer);
    }

//    @Override
//    public Question add(Question question) {
//        if (questions.contains(question)) {
//            throw new QuestionIsAlreadyCreatedException();
//        }
//        questions.add(question);
//        return question;
//    }

    @Override
    public Question remove(String question, String answer) {
        return questionRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return questionRepository.all();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt(questionRepository.all().size());
        List<Question> list = new ArrayList<>(questionRepository.all());
        return list.get(random);

    }
}
