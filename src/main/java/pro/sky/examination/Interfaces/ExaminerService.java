package pro.sky.examination.Interfaces;

import pro.sky.examination.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
