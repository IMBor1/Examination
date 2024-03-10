package pro.sky.examination.Interfaces;

import pro.sky.examination.Question;

import java.util.Set;

public interface QuestionService {
    Question add(String question, String answer);

    //Question add(Question question);

    Question remove(String question, String answer);

    Set<Question> getAll();

    Question getRandomQuestion();
}
