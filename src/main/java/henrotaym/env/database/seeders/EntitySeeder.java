package henrotaym.env.database.seeders;

import henrotaym.env.database.factories.EntityFactory;
import henrotaym.env.enums.ProfileName;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(ProfileName.SEEDER)
public abstract class EntitySeeder<T> implements ApplicationRunner {
  protected abstract EntityFactory<T> getFactory();

  protected Integer getCount() {
    return 100;
  }

  protected T seed(Integer index) {
    return this.getFactory().create();
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    for (int i = 0; i < this.getCount(); i++) {
      this.seed(i);
    }
  }
}
