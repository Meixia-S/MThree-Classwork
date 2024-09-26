package Monster.src.main.java.com.sg.testing.dao.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


import Monster.src.main.java.com.sg.testing.model.Monster;
import Monster.src.main.java.com.sg.testing.model.MonsterType;

import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoC;
import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoD;
import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoE;
import Monster.src.main.java.com.sg.testing.dao.implementations.buggy.BadMonsterDaoF;

public class MonsterServiceTest {

  private BadMonsterDaoF monsterService;

  @BeforeEach
  void setUp() {
    monsterService = new BadMonsterDaoF();  // Assuming MonsterService is the class you're testing
  }

  @Test
  void testAddMonster() {
    Monster monster = new Monster("Bigfoot", MonsterType.YETI, 0, "Berries");
    assertNull(monsterService.addMonster(1, monster), "Adding a new monster should return null");

    Monster anotherMonster = new Monster("Swampy", MonsterType.SWAMPTHING, 5, "Fish");
    assertEquals(monster, monsterService.addMonster(1, anotherMonster), "Adding a monster with an existing ID should return the old monster");
    assertEquals(1, monsterService.monsters.size());
  }

  @Test
  void testGetMonster() {
    Monster monster = new Monster("Bigfoot", MonsterType.YETI, 0, "Berries");
    monsterService.addMonster(1, monster);
    assertEquals(monster, monsterService.getMonster(1), "Getting a monster by its ID should return the correct monster");

    assertNull(monsterService.getMonster(2), "Getting a monster with a non-existing ID should return null");
    assertEquals(1, monsterService.monsters.size());
  }

  @Test
  void testGetAllMonsters() {
    Monster monster1 = new Monster("Bigfoot", MonsterType.YETI, 0, "Berries");
    Monster monster2 = new Monster("Swampy", MonsterType.SWAMPTHING, 5, "Fish");

    monsterService.addMonster(1, monster1);
    monsterService.addMonster(2, monster2);

    List<Monster> monsters = monsterService.getAllMonsters();
    assertEquals(2, monsters.size(), "There should be 2 monsters in the list");
    assertTrue(monsters.contains(monster1), "The list should contain the first monster");
    assertTrue(monsters.contains(monster2), "The list should contain the second monster");
  }

  @Test
  void testUpdateMonster() {
    Monster monster = new Monster("Bigfoot", MonsterType.YETI, 0, "Berries");
    monsterService.addMonster(1, monster);

    Monster updatedMonster = new Monster("Bigfoot", MonsterType.YETI, 3, "Honey");
    monsterService.updateMonster(1, updatedMonster);

    assertEquals(updatedMonster, monsterService.getMonster(1), "The monster should be updated with the new details");

    Monster nonExistingMonster = new Monster("Dracula", MonsterType.VAMPIRE, 10, "Blood");
    monsterService.updateMonster(2, nonExistingMonster);
    assertNull(monsterService.getMonster(2), "Updating a non-existing monster should not add it to the service");
  }

  @Test
  void testRemoveMonster() {
    Monster monster = new Monster("Bigfoot", MonsterType.YETI, 0, "Berries");
    monsterService.addMonster(1, monster);

    assertEquals(monster, monsterService.removeMonster(1), "Removing a monster should return the removed monster");
    assertNull(monsterService.getMonster(1), "The removed monster should no longer be in the service");

    assertNull(monsterService.removeMonster(2), "Removing a non-existing monster should return null");
  }

  @Test
  void testEmptyService() {
    List<Monster> monsters = monsterService.getAllMonsters();
    assertTrue(monsters.isEmpty(), "The service should initially be empty");
  }

//  @IO.Address.Test
//  void testUpdateNullMonster() {
//    assertThrows(NullPointerException.class, () -> {
//      monsterService.updateMonster(1, null);
//    }, "Updating with a null monster should throw an exception");
//  }
}
