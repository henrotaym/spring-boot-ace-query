package henrotaym.env.database.factories;

import henrotaym.env.entities.Player;
import java.math.BigInteger;
import net.datafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactory extends EntityFactory<Player> {

  public PlayerFactory(Faker faker, JpaRepository<Player, BigInteger> repository) {
    super(faker, repository);
  }

  @Override
  protected Player entity() {
    return new Player();
  }

  @Override
  protected void attributes(Player entity) {
    entity.setBirthDate(this.faker.timeAndDate().birthday(18, 45));
    entity.setName(this.faker.name().fullName());
    entity.setNationality(this.faker.nation().nationality());
    entity.setRanking(this.faker.random().nextInt(1, 200));
  }
}
