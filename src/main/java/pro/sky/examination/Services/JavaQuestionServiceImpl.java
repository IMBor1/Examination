package pro.sky.examination.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;
import pro.sky.examination.Repositories.JavaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
@Qualifier
public class JavaQuestionServiceImpl implements QuestionService {
    private final JavaRepository javaRepository;

    public JavaQuestionServiceImpl(JavaRepository javaRepository) {
        this.javaRepository = javaRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaRepository.add(question, answer);
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
        return javaRepository.remove(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return javaRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt(javaRepository.getAll().size());
        List<Question> list = new ArrayList<>(javaRepository.getAll());
        return list.get(random);

    }
}
