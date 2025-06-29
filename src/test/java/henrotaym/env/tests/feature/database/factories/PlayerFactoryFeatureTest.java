package henrotaym.env.tests.feature.database.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import henrotaym.env.ApplicationTest;
import henrotaym.env.database.factories.PlayerFactory;
import henrotaym.env.entities.Player;
import henrotaym.env.repositories.PlayerRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerFactoryFeatureTest extends ApplicationTest {
  @Autowired PlayerFactory playerFactory;
  @Autowired EntityManager entityManager;
  @Autowired PlayerRepository playerRepository;

  @Test
  public void it_creates_players_using_dedicated_factory() {
    Player player = this.playerFactory.create();
    entityManager.flush();
    entityManager.clear();

    assertEquals(1, this.playerRepository.count());
    assertEquals(player.getId(), this.playerRepository.findAll().getFirst().getId());
  }
}
