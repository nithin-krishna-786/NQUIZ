package com.crio.codingame.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;

public class ContestRepository implements IContestRepository {

    private final Map<String,Contest> contestMap;
    private Integer autoIncrement = 0;
    
    public ContestRepository() {
        contestMap = new HashMap<String,Contest>();
    }

    public ContestRepository(Map<String, Contest> contestMap) {
        this.contestMap = contestMap;
        this.autoIncrement = contestMap.size();
    }

    @Override
    public Contest save(Contest entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Contest c = new Contest(Integer.toString(autoIncrement),entity.getName(),entity.getQuestions(),entity.getLevel(),entity.getCreator(),entity.getContestStatus());
            contestMap.put(c.getId(),c);
            return c;
        }
        contestMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Contest Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Contest> findAll() {
        List<Contest> contests = new ArrayList<>(); 
        for(Contest c:contestMap.values())
        {
            contests.add(c);
        }    
     //return Collections.emptyList();
        return contests;
    }

    @Override
    public Optional<Contest> findById(String id) {
        return Optional.ofNullable(contestMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        if(contestMap.containsKey(id))
        {
                return true;
        }        
        else
        {
                return false;
        }
                //return false;
    }

    @Override
    public void delete(Contest entity) {
        // TODO Auto-generated method stub
        String contestID = entity.getId();
        if(contestMap.containsKey(contestID))
        {
            contestMap.remove(contestID);
        }    
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        contestMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return contestMap.size();
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Contest Present in the Repository provided Level
    // Tip:- Use Java Streams

    @Override
    public List<Contest> findAllContestLevelWise(Level level) {
        // return contestMap.values()
        //        .stream()
        //        .filter(contest -> level.equals(contest.getLevel()))
        //        .collect(Collectors.toList());

        List<Contest> contests = new ArrayList<>();
        contests = findAll();
        List<Contest> ret = new ArrayList<>();

        for(Contest contest : contests)
        {
            if(contest.getLevel().equals(level))
            ret.add(contest);
        }

        return ret; 
    }

    
}
