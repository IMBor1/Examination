package pro.sky.examination.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examination.Exceptions.CollectionFullException;
import pro.sky.examination.Interfaces.ExaminerService;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionServiceImpl;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionServiceImpl,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionServiceImpl = javaQuestionServiceImpl;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Set<Question> getQuestions(int amount) {
        Random r = new Random();
        Set<Question> setRandom = new HashSet<>();

        if (javaQuestionServiceImpl.getAll().size() +
                mathQuestionService.getAll().size() <= amount) {
            throw new CollectionFullException();
        }
        return Stream.generate(this::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());

//        int ind = r.nextInt(2);
//        while (setRandom.size() <= amount) {
//
//            if (ind == 0) {
//                setRandom.add(javaQuestionServiceImpl.getRandomQuestion());
//            } else  {
//                setRandom.add(mathQuestionService.getRandomQuestion());
//            }
//        }
//        return setRandom;
//    }
    }

    private Question getRandomQuestion() {
        Random random = new Random();
        int ind = random.nextInt(2);
        if (ind == 0) {
            return javaQuestionServiceImpl.getRandomQuestion();
        } else {
            return mathQuestionService.getRandomQuestion();
        }
    }
}
