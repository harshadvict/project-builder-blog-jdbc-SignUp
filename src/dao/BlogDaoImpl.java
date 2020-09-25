package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	
	@Override
	public void insertBlog(Blog blog) {
		
		//method to insert the blog into the database.
		ConnectionManager con=new ConnectionManager();
		try {
			Connection conn=con.getConnection();
			String sql="insert into blog(id,title,blog_description,posted_date)values(?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1,blog.getBlogId());
			stmt.setString(2,blog.getBlogTitle());
			stmt.setString(3, blog.getBlogDescription());
			stmt.setString(4, blog.getPostedOn().toString());
			stmt.executeUpdate();
			System.out.println("data uploded in the database");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Blog> selectAllBlogs() {
		//method to retrieve the blogs from the database.
		ConnectionManager con=new ConnectionManager();
		try {
			Connection conn=con.getConnection();
			String sql="select * from blog";
			PreparedStatement stmt=conn.prepareStatement(sql);
			Blog blogObject=new Blog();
			ResultSet rs=stmt.executeQuery();
			List<Blog> list=new ArrayList<>();
			while(rs.next()) {
					blogObject.setBlogId(rs.getInt(1));
					blogObject.setBlogTitle(rs.getString(2));
					blogObject.setBlogDescription(rs.getString(3));
					DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String stringDate=rs.getString(4);
					LocalDate date=LocalDate.parse(stringDate,format);
					blogObject.setPostedOn(date);
					list.add(blogObject);
					}
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
