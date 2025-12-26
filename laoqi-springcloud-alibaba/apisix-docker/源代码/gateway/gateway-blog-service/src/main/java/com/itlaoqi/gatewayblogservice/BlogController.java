package com.itlaoqi.gatewayblogservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BlogController {
    
    private List<Blog> blogList = new ArrayList<>();

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        // TODO: Implement logic to get all blogs from the database
        Random random = new Random();
        int numBlogs = random.nextInt(20) + 1;
        List<Blog> blogs = new ArrayList<>();
        for (int i = 0; i < numBlogs; i++) {
            Blog blog = new Blog();
            blog.setId(Long.valueOf(i+1));
            blog.setTitle("Blog " + (i+1));
            blog.setContent("This is the content of Blog " + (i+1));
            blogs.add(blog);
        }
        return blogs;
    }
    
    @GetMapping("/blog/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        // TODO: Implement logic to get blog by ID from the database
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle("Blog " + id);
        blog.setContent("This is the content of Blog " + id);
        return blog;
    }
    
    @GetMapping("/blog/search")
    public List<Blog> searchBlogs(@RequestParam("query") String query) {
        // TODO: Implement logic to search blogs in the database
        Random random = new Random();
        int numBlogs = random.nextInt(10) + 1;
        List<Blog> blogs = new ArrayList<>();
        for (int i = 0; i < numBlogs; i++) {
            Blog blog = new Blog();
            blog.setId(Long.valueOf(i+1));
            blog.setTitle("Blog " + (i+1));
            blog.setContent("This is the content of Blog " + (i+1));
            blogs.add(blog);
        }
        return blogs;
    }
}