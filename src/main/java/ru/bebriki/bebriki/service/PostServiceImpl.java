package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.models.Achievement;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPostById(int id) {

        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new IllegalArgumentException("There is no such achievement like this");
        }

        return post.get();

    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostByName(String name) {

        Post post = postRepository.findByName(name);

        if (post == null) {
            throw new IllegalArgumentException("There is no such achievement like this");
        }

        return post;

    }

    @Override
    public void deletePostById(int id) {

        if (postRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("no such task");
        }
        postRepository.deleteById(id);

    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
