package com.win.blog.controllers;

import com.win.blog.models.BlogPost;
import com.win.blog.models.BlogPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogPostController {
    private BlogPostRepository blogPostRepository;
    private List<BlogPost> posts;

    public BlogPostController(List<BlogPost> posts, BlogPostRepository blogPostRepository){
        this.blogPostRepository = blogPostRepository;
        this.posts = posts;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping(value = "/blog_posts/new")
    public String newBlog(BlogPost blogPost) {
        return "new";
    }

    @PostMapping(value = "/blog_posts/new")
    public String addNewBlogPost(BlogPost blogPost, Model model){
        blogPostRepository.save(blogPost);
        posts.add(blogPost);

        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());

        return "result";
    }

    private void mirrorDB(){
        Iterable<BlogPost> blogList = blogPostRepository.findAll();
        posts.clear();
        for (BlogPost blogPost: blogList) posts.add(blogPost);
    }

    @DeleteMapping("/blog_posts/{id}/delete")
    public String deleteBlogPost(@PathVariable("id") Long id) {
        blogPostRepository.deleteById(id);
        mirrorDB();
        return "result";
    }

    @PutMapping("/blog_posts/{id}/edit")
    public String editBlogEntryPut(BlogPost bp, Model model) {
        blogPostRepository.save(bp);
        mirrorDB();
        model.addAttribute("title", bp.getTitle());
        model.addAttribute("author", bp.getAuthor());
        model.addAttribute("blogEntry", bp.getBlogEntry());
        return "result";
    }

    @GetMapping("blog_posts/{id}/edit")
    public String editBlogEntryView(@PathVariable("id") Long id, Model model) {
        Optional<BlogPost> schrödingersBlogPost = blogPostRepository.findById(id);
        model.addAttribute("blogPost", schrödingersBlogPost.get());
        return "edit";
    }
}
