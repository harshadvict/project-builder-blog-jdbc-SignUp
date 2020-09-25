package dao;

import java.util.List;

import model.Blog;

interface BlogDaoInterface {
	void insertBlog(Blog blog);
	List<Blog> selectAllBlogs();
}
