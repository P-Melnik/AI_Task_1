package internship.AI_task_1.service;

import internship.AI_task_1.entity.Post;
import internship.AI_task_1.entity.User;

import java.util.List;

public interface PostService {

    Post createPost(Post post);
    List<Post> getPostsByUser(User user);

    Post findPostById (Long postId);

    Post updatePost(Post post);
}
