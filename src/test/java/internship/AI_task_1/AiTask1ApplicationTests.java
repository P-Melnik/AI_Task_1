package internship.AI_task_1;

import internship.AI_task_1.controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class AiTask1ApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception{
		assertTrue(userController!=null);
	}

}
