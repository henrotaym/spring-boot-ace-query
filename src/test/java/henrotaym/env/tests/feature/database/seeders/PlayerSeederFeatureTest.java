package henrotaym.env.tests.feature.database.seeders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import henrotaym.env.ApplicationTest;
import henrotaym.env.database.seeders.PlayerSeeder;
import henrotaym.env.repositories.PlayerRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerSeederFeatureTest extends ApplicationTest {
  @Autowired EntityManager entityManager;
  @Autowired PlayerSeeder playerSeeder;
  @Autowired PlayerRepository playerRepository;

  @Test
  public void it_creates_players_using_dedicated_factory() {
    Integer count = 100;
    this.playerSeeder.seed(count);
    entityManager.flush();
    entityManager.clear();

    assertEquals(count.longValue(), this.playerRepository.count());
  }
}
