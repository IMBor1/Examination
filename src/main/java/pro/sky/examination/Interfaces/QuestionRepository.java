package pro.sky.examination.Interfaces;

import pro.sky.examination.Question;

import java.util.Set;

public interface QuestionRepository {
    Question addQuestion(String question, String answer);

    Question remove(String question, String answer);

    Set<Question> all();
}
