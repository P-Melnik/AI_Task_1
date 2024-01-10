package internship.AI_task_1;

import internship.AI_task_1.entity.User;
import internship.AI_task_1.repository.UserRepository;
import internship.AI_task_1.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void getUserByIdTest() {
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUserById(userId);

        assertNotNull(retrievedUser);
        verify(userRepository, times(1)).findById(userId);
    }


}
