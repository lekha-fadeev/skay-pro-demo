package pro.sky.skayprodemo.repository;

import pro.sky.skayprodemo.entity.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        this.add("java_q1", "java_a1");
        this.add("java_q2", "java_a2");
        this.add("java_q3", "java_a3");
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
