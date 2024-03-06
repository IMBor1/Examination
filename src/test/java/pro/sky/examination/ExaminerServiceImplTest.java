package pro.sky.examination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examination.Interfaces.QuestionService;
import pro.sky.examination.Services.ExaminerServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService mockQuestionService;

    @InjectMocks
    ExaminerServiceImpl out;
    Question one = new Question("How old are you?", "30");
    Question two = new Question("How are you?", "i'm fine");
    Question three = new Question("How are you?", "i'm great");
    Question four = new Question("Where are you from?", "i'm from Russia");
    Set<Question> all = new HashSet<>(Set.of(one, two, three, four));


    @Test
    void getSizeRandomQuestions() {

        when(mockQuestionService.getAll())
                .thenReturn(all);
        when(mockQuestionService.getRandomQuestion())
                .thenReturn(two);
        assertEquals(4, out.getQuestions(4));
    }
}
