package henrotaym.env.commands.database.seeders;

import henrotaym.env.database.seeders.PlayerSeeder;
import henrotaym.env.enums.ProfileName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(ProfileName.SEEDER)
@Configuration
@RequiredArgsConstructor
public class SeedDatabaseCommand implements ApplicationRunner {
  private final PlayerSeeder playerSeeder;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    this.playerSeeder.seed(100);
  }
}
