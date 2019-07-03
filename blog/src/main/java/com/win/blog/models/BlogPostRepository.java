package com.win.blog.models;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository <BlogPost, Long> {
}
