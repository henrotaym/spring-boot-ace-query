package henrotaym.env.mappers;

import henrotaym.env.entities.Player;
import henrotaym.env.http.requests.PlayerRequest;
import henrotaym.env.http.resources.PlayerResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapper {
  public PlayerResource resource(Player player) {
    return new PlayerResource(
        player.getId(),
        player.getName(),
        player.getNationality(),
        player.getBirthDate(),
        player.getRanking());
  }

  public Player request(PlayerRequest request, Player player) {
    player.setBirthDate(request.getBirthDate());
    player.setName(request.getName());
    player.setNationality(request.getNationality());
    player.setRanking(request.getRanking());

    return player;
  }
}
