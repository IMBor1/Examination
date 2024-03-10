package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Interfaces.QuestionRepository;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;
import pro.sky.examination.Repositories.MathRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
public class MathQuestionService implements QuestionService {

    QuestionRepository questionRepository;

    public MathQuestionService(MathRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Question add(String question, String answer) {
        return questionRepository.addQuestion(question, answer);

    }

//    @Override
//    public Question add(Question question) {
//        if (mathQuestions.contains(question)) {
//            throw new QuestionIsAlreadyCreatedException();
//        }
//        mathQuestions.add(question);
//        return question;
//    }

    @Override
    public Question remove(String question, String answer) {
        return questionRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return (Set<Question>) questionRepository.all();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt(questionRepository.all().size());
        List<Question> list = new ArrayList<>(questionRepository.all());
        return list.get(random);

    }
}


