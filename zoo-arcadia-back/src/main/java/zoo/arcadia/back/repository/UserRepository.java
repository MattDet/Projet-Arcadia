package zoo.arcadia.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
