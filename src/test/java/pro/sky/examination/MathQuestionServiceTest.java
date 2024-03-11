package pro.sky.examination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examination.Exceptions.QuestionIsAlreadyCreatedException;
import pro.sky.examination.Exceptions.QuestionNotFoundException;
import pro.sky.examination.Repositories.MathRepository;
import pro.sky.examination.Services.MathQuestionService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathRepository mockMathRepository;
    @InjectMocks
    private MathQuestionService out;
    Question oneQuestion = new Question("q1", "a1");
    Question twoQuestion = new Question("q2", "a2");
    Question threeQuestion = new Question("q3", "a3");
    Set<Question> allQuestions = new HashSet<>(Set.of(oneQuestion, twoQuestion, threeQuestion));


    @Test
    void addNewQuestion() {
        when(mockMathRepository.addQuestion("q1", "a1"))
                .thenReturn(oneQuestion);
        assertEquals(oneQuestion, out.add("q1", "a1"));
    }


    @Test
    void addWhenQuestionCreated() {
        when(mockMathRepository.addQuestion("q1", "a1"))
                .thenThrow(QuestionIsAlreadyCreatedException.class);
        assertThrows(QuestionIsAlreadyCreatedException.class,
                () -> out.add("q1", "a1"));
    }

    @Test
    void removeQuestion() {
        mockMathRepository.addQuestion("q1", "a1");
        when(mockMathRepository.remove("q1", "a1"))
                .thenReturn(oneQuestion);
        assertEquals(oneQuestion, out.remove("q1", "a1"));
        when(mockMathRepository.remove("q1", "a1"))
                .thenThrow(QuestionNotFoundException.class);
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove("q1", "a1"));
    }

    @Test
    void getAllTest() {
        when(mockMathRepository.all())
                .thenReturn(allQuestions);
        out.add("q1", "a1");
        out.add("q2", "a2");
        out.add("q3", "a3");
        assertEquals(allQuestions, out.getAll());
    }
}
