package pro.sky.skayprodemo.services;

import pro.sky.skayprodemo.entity.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
