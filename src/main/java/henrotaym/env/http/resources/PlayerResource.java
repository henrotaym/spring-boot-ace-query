package henrotaym.env.http.resources;

import java.math.BigInteger;
import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlayerResource {
  private final BigInteger id;
  private final String name;
  private final String nationality;
  private final LocalDate birthDate;
  private final Integer ranking;
}
