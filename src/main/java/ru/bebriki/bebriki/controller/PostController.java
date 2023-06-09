package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/name")
    public Post getPostByName(@RequestParam(value = "name") String name) {
        return postService.getPostByName(name);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable("id") int id) {
        postService.deletePostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

}
