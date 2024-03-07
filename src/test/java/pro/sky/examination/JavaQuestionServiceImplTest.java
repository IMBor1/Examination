package pro.sky.examination;

import org.junit.jupiter.api.Test;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Services.JavaQuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceImplTest {
    Set<Question> testSet = new HashSet<>();
    JavaQuestionServiceImpl out = new JavaQuestionServiceImpl(testSet);


    Question one = new Question("How old are you?", "30");
    Question two = new Question("How are you?", "i'm fine");
    Question three = new Question("How are you?", "i'm great");
    Question four = new Question("Where are you from?", "i'm from Russia");
    Set<Question> all = new HashSet<>(Set.of(one, two, three, four));


    @Test
    void addNewQuestion() {
        Question result = out.add("How old are you?", "30");
        assertEquals(result, one);
    }

    @Test
    void addWhenQuestionCreated() {
        Question result = out.add("How old are you?", "30");
        assertThrows(QuestionIsAlreadyCreatedException.class, () -> out.add(result));
    }

    @Test
    void removeQuestion() {
        out.add("How are you?", "i'm fine");
        out.remove("How are you?", "i'm fine");
        assertEquals(0, out.getAll().size());
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("How are you?", "i'm fine"));
    }

    @Test
    void getAllTest() {
        out.add(one);
        out.add(two);
        out.add(three);
        out.add(four);
        Set<Question> result = out.getAll();
        assertEquals(result, all);
    }
}
