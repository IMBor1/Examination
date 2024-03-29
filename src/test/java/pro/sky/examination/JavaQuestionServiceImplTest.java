package pro.sky.examination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Repositories.JavaRepository;
import pro.sky.examination.Services.JavaQuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {
    @Mock
    private JavaRepository mockjavaRepository;
    @InjectMocks
    private JavaQuestionServiceImpl out;
    Question oneQuestion = new Question("q1", "a1");
    Question twoQuestion = new Question("q2", "a2");
    Question threeQuestion = new Question("q3", "a3");
    Set<Question> allQuestions = new HashSet<>(Set.of(oneQuestion, twoQuestion, threeQuestion));


    @Test
    void addNewQuestion() {
        when(mockjavaRepository.addQuestion("q1", "a1"))
                .thenReturn(oneQuestion);
        assertEquals(oneQuestion, out.add("q1", "a1"));
    }


    @Test
    void addWhenQuestionCreated() {
        when(mockjavaRepository.addQuestion("q1", "a1"))
                .thenThrow(QuestionIsAlreadyCreatedException.class);
        //Question result = out.add("How old are you?", "30");
        assertThrows(QuestionIsAlreadyCreatedException.class,
                () -> out.add("q1", "a1"));
    }

    @Test
    void removeQuestion() {
        mockjavaRepository.addQuestion("q1", "a1");
        when(mockjavaRepository.remove("q1", "a1"))
                .thenReturn(oneQuestion);
        assertEquals(oneQuestion, out.remove("q1", "a1"));
        when(mockjavaRepository.remove("q1", "a1"))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("q1", "a1"));
    }

    @Test
    void getAllTest() {
        when(mockjavaRepository.all())
                .thenReturn(allQuestions);
        out.add("q1", "a1");
        out.add("q2", "a2");
        out.add("q3", "a3");
        assertEquals(allQuestions, out.getAll());
    }
}
