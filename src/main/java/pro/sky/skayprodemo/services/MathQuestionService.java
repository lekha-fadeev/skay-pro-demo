package pro.sky.skayprodemo.services;

import pro.sky.skayprodemo.entity.Question;
import pro.sky.skayprodemo.exceptions.MathQuestionNotAllowed;
import pro.sky.skayprodemo.exceptions.NoQuestionsException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        throw new MathQuestionNotAllowed();
    }

    @Override
    public Question add(Question question) {
        throw new MathQuestionNotAllowed();
    }

    @Override
    public Question remove(Question question) {
        throw new MathQuestionNotAllowed();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MathQuestionNotAllowed();
    }

    @Override
    public Question getRandomQuestion() {
        var arg1 = random.nextInt(1000);
        var arg2 = random.nextInt(500) + 100;

        StringBuilder result = new StringBuilder();
        result.append(arg1);
        double mathResult = generateOperation(result, arg1, arg2);
        result.append(arg2);
        return new Question(result.toString(), String.valueOf(mathResult));
    }

    // POSTMAN
    private double generateOperation(StringBuilder result, int arg1, int arg2) {
        switch (random.nextInt(4)) {
            case 0:
                result.append(" + ");
                return arg1 + arg2;
            case 1:
                result.append(" - ");
                return arg1 - arg2;
            case 2:
                result.append(" * ");
                return arg1 * arg2;
            case 3:
                result.append(" / ");
                return (double) arg1 / arg2;
            default:
                throw new UnsupportedOperationException("Unknown operation");
        }
    }
}
