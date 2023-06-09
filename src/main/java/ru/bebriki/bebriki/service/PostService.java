package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.models.Post;

import java.util.List;

public interface PostService {
    Post getPostById(int id);

    List<Post> getAllPosts();

    Post getPostByName(String name);

    void deletePostById(int id);

    Post createPost(Post post);
}
