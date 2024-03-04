package pro.sky.examination.Services;

import org.springframework.stereotype.Service;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Question;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionServiceImpl(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        if (questions.contains(question)) {
            throw new QuestionIsAlreadyCreatedException();
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionIsAlreadyCreatedException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1.getQuestion()) &&
                questions.contains((question1.getAnswer()))) {

            questions.remove(question1);
            return question1;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        Set<Question> questionSet = new HashSet<>(questions);
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        int random = r.nextInt() + questions.size();
        List<Question> list = new ArrayList<>(questions);
        return list.get(random);

    }
}
