import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    Booking save(Booking entity);
    Optional<Booking> findById(String id);
    List<Booking> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
