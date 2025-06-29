package henrotaym.env.database.seeders;

import com.querydsl.jpa.impl.JPAQueryFactory;
import henrotaym.env.database.factories.EntityFactory;
import henrotaym.env.database.factories.PlayerFactory;
import henrotaym.env.entities.Player;
import henrotaym.env.entities.QPlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PlayerSeeder extends EntitySeeder<Player> {
  private final PlayerFactory playerFactory;
  private final JPAQueryFactory jpaQueryFactory;
  private Integer minimalRank;

  @Override
  protected EntityFactory<Player> getFactory() {
    return this.playerFactory;
  }

  @Override
  protected Player seed(Integer index) {

    return this.getFactory().create(player -> player.setRanking(index + 1 + this.getMinimalRank()));
  }

  private Integer getMinimalRank() {
    if (this.minimalRank != null) {
      return this.minimalRank;
    }

    Integer currentMinimalRank =
        this.jpaQueryFactory.from(QPlayer.player).select(QPlayer.player.ranking.max()).fetchOne();

    this.minimalRank = currentMinimalRank == null ? 0 : currentMinimalRank;

    return this.minimalRank;
  }
}
