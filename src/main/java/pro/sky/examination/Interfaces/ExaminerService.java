package pro.sky.examination.Interfaces;

import pro.sky.examination.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}
