package com.crio.codingame.services;

import java.util.List;
import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Create and store Question into the repository.

    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
        Question qn = new Question("1",title, level, difficultyScore);
        questionRepository.save(qn);
        return qn;
        // return questionRepository.save(new Question(title,level,difficultyScore));
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
     //return Collections.emptyList(); //ORIG

    if(level == null)
            return questionRepository.findAll();
    else
            return questionRepository.findAllQuestionLevelWise(level);            
    } 

    
    
}
