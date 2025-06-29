package henrotaym.env.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import henrotaym.env.enums.ProfileName;
import net.datafaker.Faker;

@Configuration
@Profile({ProfileName.TEST, ProfileName.SEEDER})
public class FakerConfiguration {
  @Bean
  Faker faker() {
    return new Faker();
  }
}
