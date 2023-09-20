package pro.sky.skayprodemo.services;

import org.junit.jupiter.api.Assertions;
import pro.sky.skayprodemo.entity.Question;
import pro.sky.skayprodemo.exceptions.NotEnoughQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
@Mock
    JavaQuestionService JavaQuestionService;
@InjectMocks
    ExaminerServiceImpl service;

@Test
    void testGetRandomWhenEmpty(){
    when(javaQuestionService.getAll()).thenReturn(Collections.emptySet());
    assertThrows(NotEnoughQuestionsException.class, () -> service.getQuestions(1));
}
    @Test
    void testWhenAmountEqualsQuestionsSize(){
    var qa = Set.of(new Question("q1", "a1"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        assertSame(service.getQuestions(1), qa);
    }
    @Test
    void testWhenAmountLssQuestionsSize() {
        var qa = Set.of(new Question("q1", "a1"), new Question("q2", "a2"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        assertNotSame(service.getQuestions(1), qa);
    }
    @Test
    void testGetRandomQuestions() {
        var qa = Set.of(new Question("q1", "a1"), new Question("q2", "a2"),new Question("q3", "a3"));
        when(javaQuestionService.getAll()).thenReturn(qa);
        when(javaQuestionService.getRandomQuestions())
                .thenReturn(new Question("q1", "a1"))
                .thenReturn(new Question("q2", "a2"))
                .thenReturn(new Question("q3", "a3"));

        var actual = service.getQuestions(2);
        Assertions.assertThat(actual).containsExactly(
                new Question("q1", "a1"),
        new Question("q2", "a2"));
    }
}