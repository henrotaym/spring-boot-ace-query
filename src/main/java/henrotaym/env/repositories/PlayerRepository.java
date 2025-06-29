package henrotaym.env.repositories;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import henrotaym.env.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, BigInteger> {}
