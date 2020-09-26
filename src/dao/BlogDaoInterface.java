package dao;

import java.util.List;

import model.Blog;

interface BlogDaoInterface {
	void insertBlog(Blog blog);
	List<Blog> selectAllBlogs();
	boolean updateBlog(Blog blog);
	public boolean deleteBlog(int id);
	public Blog selectBlog(int blogid);
}
