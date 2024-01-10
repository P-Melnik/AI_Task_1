package internship.AI_task_1;

import internship.AI_task_1.entity.Post;
import internship.AI_task_1.entity.User;
import internship.AI_task_1.repository.PostRepository;
import internship.AI_task_1.service.PostServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl
            postService;

    @Test
    public void createPostTest() {
        Post post = new Post();
        when(postRepository.save(any(Post.class))).thenReturn(post);

        Post createdPost = postService.createPost(post);

        assertNotNull(createdPost);
        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void getPostsByUserTest() {
        Long userId = 1L;
        User user = new User();
        when(postRepository.findByAuthor(user)).thenReturn(Collections.emptyList());

        List<Post> posts = postService.getPostsByUser(user);

        assertNotNull(posts);
        verify(postRepository, times(1)).findByAuthor(user);
    }

}
