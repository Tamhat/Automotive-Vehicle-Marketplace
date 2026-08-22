import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User entity);
    Optional<User> findById(String id);
    List<User> findAll();
    void deleteById(String id);
    boolean existsById(String id);
    long count();
}
