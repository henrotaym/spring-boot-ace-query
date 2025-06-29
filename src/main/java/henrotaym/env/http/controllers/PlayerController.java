package henrotaym.env.http.controllers;

import henrotaym.env.entities.Player;
import henrotaym.env.http.requests.PlayerRequest;
import henrotaym.env.http.resources.PlayerResource;
import henrotaym.env.mappers.PlayerMapper;
import henrotaym.env.services.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("players")
public class PlayerController {
  private final PlayerService playerService;
  private final PlayerMapper playerMapper;

  @PostMapping("")
  public ResponseEntity<PlayerResource> store(@RequestBody @Valid PlayerRequest request) {
    Player player = this.playerService.store(request);

    return ResponseEntity.status(HttpStatus.CREATED).body(this.playerMapper.resource(player));
  }
}
