package henrotaym.env.services;

import henrotaym.env.entities.Player;
import henrotaym.env.http.requests.PlayerRequest;
import henrotaym.env.mappers.PlayerMapper;
import henrotaym.env.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;

  public Player store(PlayerRequest request) {
    Player player = new Player();

    return this.playerRepository.save(this.playerMapper.request(request, player));
  }
}
