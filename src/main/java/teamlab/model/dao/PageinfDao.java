package teamlab.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import teamlab.model.entity.Pageinf;
import teamlab.model.entity.ViewCount;


@Service
public class PageinfDao{

	@Autowired
	@Qualifier("appjdbc")
	protected JdbcTemplate jdbcTemplate;
	
	
	public List<Pageinf> findNoUserPage() {
		List<Pageinf> result = new ArrayList<>();
		jdbcTemplate.query(" select * from pageinf where user_id is null order by id limit 10", 
					(rs, column) -> new Pageinf(rs.getInt("id"), rs.getString("title"), rs.getInt("user_id"), rs.getInt("page_id")))
					.forEach(page -> result.add(page));
		return result;
	}
	public List<Pageinf> findNoUserPage(Object...params) {
		List<Pageinf> result = new ArrayList<>();
		jdbcTemplate.query(" select * from pageinf where user_id is null and title like ? order by user_id, id limit 10", 
					params,
					(rs, column) -> new Pageinf(rs.getInt("id"), rs.getString("title"), rs.getInt("user_id"), rs.getInt("page_id")))
					.forEach(page -> result.add(page));
		return result;
	}
	
	
	public List<ViewCount> findUserPage() {
		List<ViewCount> result = new ArrayList<>();
		jdbcTemplate.query(" select page_id, user_id, title, count(*) as view from pageinf p where user_id is not null group by user_id order by user_id, page_id ", 
					(rs, column) -> new ViewCount(rs.getInt("page_id"), rs.getString("title"), rs.getInt("user_id"), rs.getInt("view")))
					.forEach(todo -> result.add(todo));
		return result;
	}
	public List<ViewCount> findUserPage(Object...params) {
		List<ViewCount> result = new ArrayList<>();
		jdbcTemplate.query(" select page_id, user_id, title, count(*) as view from pageinf p where user_id is not null and title like ? group by user_id order by user_id, page_id ",  
					params,
					(rs, column) -> new ViewCount(rs.getInt("page_id"), rs.getString("title"), rs.getInt("user_id"), rs.getInt("view")))
					.forEach(todo -> result.add(todo));
		return result;
	}
	
	
	@SuppressWarnings("deprecation")
	public List<Integer> countNoUserPage() {
		List<Integer> result = new ArrayList<>();
		jdbcTemplate.query(" select count(*) as count from pageinf where user_id is null", 
					(rs, column) -> new Integer(rs.getInt("count")))
					.forEach(count -> result.add(count));
		return result;
	}
	@SuppressWarnings("deprecation")
	public List<Integer> countNoUserPage(Object...params) {
		List<Integer> result = new ArrayList<>();
		jdbcTemplate.query(" select count(*) as count from pageinf where user_id is null and title like ?", 
					params,
					(rs, column) -> new Integer(rs.getInt("count")))
					.forEach(count -> result.add(count));
		return result;
	}
	
}
