package pro.sky.examination.Repositories;

import org.springframework.stereotype.Repository;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Interfaces.QuestionRepository;
import pro.sky.examination.Question;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MathRepository implements QuestionRepository {
    private final Set<Question> mathQuestions = new HashSet<>();


    @Override
    public Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (mathQuestions.contains(newQuestion)) {
            throw new QuestionIsAlreadyCreatedException("такой вопрос уже существует");
        }
        mathQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (mathQuestions.contains(question1)) {

            mathQuestions.remove(question1);
            return question1;
        }
        throw new QuestionNotFoundException("такой вопрос не найден");
    }

    @Override
    public Set<Question> all() {
        Set<Question> questionSet = new HashSet<>(mathQuestions);
        return questionSet;
    }
}
