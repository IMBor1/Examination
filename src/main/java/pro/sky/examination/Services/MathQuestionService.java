package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Exceptions.NoMathQuestionsException;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;

import java.util.Random;
import java.util.Set;


@Service
public class MathQuestionService implements QuestionService {


    @Override
    public Question add(String question, String answer) {
        throw new NoMathQuestionsException();

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
        throw new NoMathQuestionsException();
    }

    @Override
    public Set<Question> getAll() {
        throw new NoMathQuestionsException();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int randomOperation = r.nextInt(4);
        int a = r.nextInt(10);
        int b = r.nextInt(10);
        switch (randomOperation) {
            case 0:
                return new Question(a + " + " + b, String.valueOf(a + b));
            case 1:
                return new Question(a + " - " + b, String.valueOf(a - b));
            case 2:
                return new Question(a + " * " + b, String.valueOf(a * b));
            case 3:
                return new Question(a + " / " + b, String.valueOf(a / b));
        }

        throw new IllegalArgumentException();
    }
}


