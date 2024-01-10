package internship.AI_task_1.repository;

import internship.AI_task_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
