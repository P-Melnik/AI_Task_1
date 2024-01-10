package internship.AI_task_1.service;

import internship.AI_task_1.entity.User;

public interface UserService {

    User createUser(User user);
    User getUserById(Long userId);

    User updateUser(User user);

}
