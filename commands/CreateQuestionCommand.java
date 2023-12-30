package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.services.IQuestionService;

public class CreateQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public CreateQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IQuestionService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Question22","HIGH","220"]

    @Override
    public void execute(List<String> tokens) {
        String title = tokens.get(1);
        Level level;
        String levelStr = tokens.get(2);

        if(levelStr.equals("HIGH"))
        {
            level = Level.HIGH;
        }    
        else if(levelStr.equals("MEDIUM"))
        {
            level = Level.MEDIUM;
        }
        else //(levelStr == "LOW")
        {
            level = Level.LOW;    
        }

        String difficultyScoreStr = tokens.get(3);

        Integer difficultyScore = Integer.parseInt(difficultyScoreStr);
        try
        {
            Question question = questionService.create(title,level,difficultyScore);
            System.out.println(question);
        }
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
            


    }
    
}
