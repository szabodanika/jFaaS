package danielszabo.jfaas.repository;

import danielszabo.jfaas.entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {
	Optional<Function> findByName(String name);
}
