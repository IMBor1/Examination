package pro.sky.examination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examination.Repositories.JavaRepository;
import pro.sky.examination.Services.JavaQuestionServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(mockjavaRepository.all())
                .thenReturn(allQuestions);

        //  Question result = out.add("q1", "a1");
        assertEquals(oneQuestion, out.add("q1", "a1"));
    }

//    @Test
//    void addWhenQuestionCreated() {
//        Question result = out.add("How old are you?", "30");
//        assertThrows(QuestionIsAlreadyCreatedException.class, () -> out.add(result));
//    }
//
//    @Test
//    void removeQuestion() {
//        out.add("How are you?", "i'm fine");
//        out.remove("How are you?", "i'm fine");
//        assertEquals(0, out.getAll().size());
//        assertThrows(QuestionNotFoundException.class,
//                () -> out.remove("How are you?", "i'm fine"));
//    }
//
//    @Test
//    void getAllTest() {
//        out.add(one);
//        out.add(two);
//        out.add(three);
//        out.add(four);
//        Set<Question> result = out.getAll();
//        assertEquals(result, all);
//    }
}
