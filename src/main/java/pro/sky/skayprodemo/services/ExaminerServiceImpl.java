package pro.sky.skayprodemo.services;

import pro.sky.skayprodemo.entity.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();

    private final List<QuestionService> services;

    public ExaminerServiceImpl(List<QuestionService> services) {
        this.services = services;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> result = new HashSet<>(amount);
        while (result.size() != amount) {
            Question question = services.get(random.nextInt(services.size())).getRandomQuestion();
            result.add(question);
        }
        return result;
    }
}
