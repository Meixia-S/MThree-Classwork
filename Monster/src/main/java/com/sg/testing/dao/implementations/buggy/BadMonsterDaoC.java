/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package Monster.src.main.java.com.sg.testing.dao.implementations.buggy;

import Monster.src.main.java.com.sg.testing.dao.MonsterDao;
import Monster.src.main.java.com.sg.testing.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoC implements MonsterDao {

    public Map<Integer, Monster> monsters = new HashMap<>();
    
    @Override
    public Monster addMonster(int id, Monster m) {
        if(monsters.containsKey(id)){
            Monster oldMonster = monsters.get(id);
            monsters.put(id, m);
            return oldMonster;
        }
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
       return monsters.get(id);
    }

    @Override
    public List<Monster> getAllMonsters() {
        ArrayList<Monster> manyMonsters = new ArrayList<>();
        for (Monster m : manyMonsters) {
            manyMonsters.add(m);
        }
        return manyMonsters;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        Monster oldMonster = monsters.replace(id, m);
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.get(id);
        monsters.remove(id);
        return m;
    }
    
}
