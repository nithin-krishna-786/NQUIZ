package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        List<Contest> contests;    

    if(tokens.size() == 2)
    {
        String level = tokens.get(1);

    try
    {    
        if(level.equals("HIGH"))
        {
            contests = contestService.getAllContestLevelWise(Level.HIGH);
        }
        else if(level.equals("MEDIUM"))
        {
            contests = contestService.getAllContestLevelWise(Level.MEDIUM);
        } 
        else //if(level.equals("LOW"))
        {
            contests = contestService.getAllContestLevelWise(Level.LOW);
        }
        // else
        // {   
        //     contests = contestService.getAllContestLevelWise(null);
        // }  

        // for(Contest contest:contests)
        // {
        //     System.out.println(contest);
        // }    

        System.out.println(contests.toString());
    }     
        catch(RuntimeException e)
        {
            System.out.println(e.getMessage());
        }    
    }              
    else
    {
        contests = contestService.getAllContestLevelWise(null);
        System.out.println(contests.toString());
    }
   } 
     
    
}
