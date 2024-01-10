package internship.AI_task_1;

import internship.AI_task_1.controller.PostController;
import internship.AI_task_1.entity.Post;
import internship.AI_task_1.entity.User;
import internship.AI_task_1.repository.PostRepository;
import internship.AI_task_1.service.PostServiceImpl;
import internship.AI_task_1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceImpl postService;

    @MockBean
    private UserService userService;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void testCreatePost() throws Exception {
        when(postService.createPost(any(Post.class))).thenReturn(new Post());

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindPostsByUser() throws Exception {
        when(userService.getUserById(anyLong())).thenReturn(new User());

        when(postService.getPostsByUser(any(User.class))).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/posts/user/1"))
                .andExpect(status().isFound());
    }



}
