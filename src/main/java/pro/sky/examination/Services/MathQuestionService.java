package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;
import pro.sky.examination.Repositories.MathRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
public class MathQuestionService implements QuestionService {

    MathRepository mathRepository;

    public MathQuestionService(MathRepository mathRepository) {
        this.mathRepository = mathRepository;
    }


    public Question add(String question, String answer) {
        return mathRepository.add(question, answer);

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
        return mathRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return mathRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt(mathRepository.getAll().size());
        List<Question> list = new ArrayList<>(mathRepository.getAll());
        return list.get(random);

    }
}


