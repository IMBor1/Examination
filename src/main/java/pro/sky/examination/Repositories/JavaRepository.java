package pro.sky.examination.Repositories;

import org.springframework.stereotype.Repository;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Interfaces.QuestionRepository;
import pro.sky.examination.Question;

import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaRepository implements QuestionRepository {
    private final Set<Question> javaQuestions;

    public JavaRepository(Set<Question> javaQuestions) {
        this.javaQuestions = javaQuestions;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        if (javaQuestions.contains(newQuestion)) {
            throw new QuestionIsAlreadyCreatedException("такой вопрос уже существует");
        }
        javaQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (javaQuestions.contains(question1)) {

            javaQuestions.remove(question1);
            return question1;
        }
        throw new QuestionNotFoundException("такой вопрос не найден");
    }

    @Override
    public Set<Question> getAll() {
        Set<Question> questionSet = new HashSet<>(javaQuestions);
        return questionSet;
    }
}
