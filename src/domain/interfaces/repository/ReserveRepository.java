package domain.interfaces.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Reserve {
    Optional<Reserve> findById(Integer id);
    List<Reserve> findActiveById(Integer id);
    List<Reserve> findPerPeriod(LocalDate start, LocalDate end);
    Void sa
}
