package com.crio.codingame.commands;

import java.util.ArrayList;
import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.services.IQuestionService;

public class ListQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public ListQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllQuestionLevelWise method of IQuestionService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_QUESTION","HIGH"]
    // or
    // ["LIST_QUESTION"]

    @Override
    public void execute(List<String> tokens) {
        List<Question> questions = new ArrayList<>();
        if(tokens.size() == 2)
        {
        questions = questionService.getAllQuestionLevelWise(Level.valueOf(tokens.get(1)));
        System.out.println(questions);
        }
        else
        {
        questions = questionService.getAllQuestionLevelWise(null);
        System.out.println(questions);
        }
        


        //NITHIN'S VERSION
        // String level = tokens.get(1);
        // List<Question> questions;
        // try
        // {
        //     if(level.equals("HIGH"))
        //     {
        //         questions = questionService.getAllQuestionLevelWise(Level.HIGH);
        //     }
        //     else if(level.equals("MEDIUM"))
        //     {
        //         questions = questionService.getAllQuestionLevelWise(Level.MEDIUM);
        //     } 
        //     else if(level.equals("LOW"))
        //     {
        //         questions = questionService.getAllQuestionLevelWise(Level.LOW);
        //     }
        //     else
        //     {   
        //         questions = questionService.getAllQuestionLevelWise(null);
        //     }  
    
        //     for(Question question:questions)
        //         System.out.println(question);
        // } 

        //  catch(RuntimeException e)
        //  {
        //      System.out.println(e.getMessage());
        //  }


    }
    
}
