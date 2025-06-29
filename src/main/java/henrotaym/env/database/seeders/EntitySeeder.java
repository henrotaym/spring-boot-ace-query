package henrotaym.env.database.seeders;

import henrotaym.env.database.factories.EntityFactory;
import henrotaym.env.enums.ProfileName;
import org.springframework.context.annotation.Profile;

@Profile(ProfileName.SEEDER)
public abstract class EntitySeeder<T> {
  protected abstract EntityFactory<T> getFactory();

  public void seed(Integer count) {
    for (int i = 0; i < count; i++) {
      this.row(i);
    }
  }

  protected T row(Integer index) {
    return this.getFactory().create();
  }
}
