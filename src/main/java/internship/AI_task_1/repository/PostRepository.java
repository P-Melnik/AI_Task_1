package internship.AI_task_1.repository;

import internship.AI_task_1.entity.Post;
import internship.AI_task_1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(User user);
}
