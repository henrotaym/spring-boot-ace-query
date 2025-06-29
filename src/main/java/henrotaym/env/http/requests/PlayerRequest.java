package henrotaym.env.http.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerRequest {
  @NotBlank final String name;
  @NotBlank final String nationality;
  @NotNull final LocalDate birthDate;
  @NotNull @Positive final Integer ranking;
}
