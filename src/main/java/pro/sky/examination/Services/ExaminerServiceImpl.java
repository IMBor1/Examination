package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Interfaces.ExaminerService;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionService;

    public ExaminerServiceImpl(List<QuestionService> questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Random r = new Random();
        Set<Question> setRandom = new HashSet<>();

        return Stream.generate(this::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toSet());

    }
    private Question getRandomQuestion() {
        Random random = new Random();
        int ind = random.nextInt(questionService.size());

        return questionService.get(ind).getRandomQuestion();

    }
}
