package pro.sky.skayprodemo.services;

import pro.sky.skayprodemo.entity.Question;
import pro.sky.skayprodemo.exceptions.NoQuestionsException;
import pro.sky.skayprodemo.repository.JavaQuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final JavaQuestionRepository repository;

    public JavaQuestionService(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var questions = repository.getAll();
        if (questions.isEmpty()) {
            throw new NoQuestionsException();
        }
        var index = random.nextInt(questions.size());
        var it = questions.iterator();
        int i = 0;
        while (it.hasNext()) {
            Question q = it.next();
            if (i == index) {
                return q;
            }
            i++;
        }
        return null;
    }
}
