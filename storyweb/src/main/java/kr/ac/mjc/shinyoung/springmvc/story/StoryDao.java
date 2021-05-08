package kr.ac.mjc.shinyoung.springmvc.story;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class StoryDao {
	
	private final String LIST_STORYS = "select content, left(date,16)date, name from story order by seq desc limit ?, ?";
	private final String ADD_STORYS = "insert story(content, name) values(:content, :name)";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<Story> STORY_ROW_MAPPER = new BeanPropertyRowMapper<>(
			Story.class);
	
	public List<Story> listStory(int offset, int count) {
		return jdbcTemplate.query(LIST_STORYS, STORY_ROW_MAPPER, offset, count);
	}
	
	
	
	public int addStory(Story story) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(story);
		return namedParameterJdbcTemplate.update(ADD_STORYS, params);
	}
	
	
			

}
