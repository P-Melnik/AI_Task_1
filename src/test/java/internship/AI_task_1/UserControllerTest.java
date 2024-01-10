package internship.AI_task_1;

import internship.AI_task_1.controller.UserController;
import internship.AI_task_1.entity.User;
import internship.AI_task_1.repository.UserRepository;
import internship.AI_task_1.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUserTest() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(new User());

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void getUserByIdTest() throws Exception {
        when(userService.getUserById(anyLong())).thenReturn(new User());

        mockMvc.perform(get("/users/1"))
                .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    public void testFollowUser() throws Exception {
        when(userService.getUserById(anyLong())).thenReturn(new User());

        when(userService.updateUser(any(User.class))).thenReturn(new User());

        mockMvc.perform(post("/users/1/follow")
                        .param("followerId", "2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
