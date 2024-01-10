package internship.AI_task_1.controller;

import internship.AI_task_1.entity.Post;
import internship.AI_task_1.entity.User;
import internship.AI_task_1.service.PostService;
import internship.AI_task_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> findPostsByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            List<Post> posts = postService.getPostsByUser(user);
            return new ResponseEntity<>(posts, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{userId}/{postId}")
    public ResponseEntity<Post> findSpecificPostByUser(@PathVariable Long userId,
                                                      @PathVariable Long postId) {
        User user = userService.getUserById(userId);
        Post post = postService.findPostById(postId);
        if (post != null && user != null) {
            return new ResponseEntity<>(post, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/{userId}/{postId}/like")
    public ResponseEntity<Post> likePost(@PathVariable Long userId,
                                         @PathVariable Long postId) {
        Post post = postService.findPostById(postId);

        if (post != null) {
            post.setLikes(post.getLikes() + 1);
            postService.updatePost(post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
