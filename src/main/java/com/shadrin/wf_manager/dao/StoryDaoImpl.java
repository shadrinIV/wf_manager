package com.shadrin.wf_manager.dao;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shadrin.wf_manager.entity.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.shadrin.wf_manager.mapper.StoryMapper;
import com.shadrin.wf_manager.dao.StoryDao;

@Repository
public class StoryDaoImpl implements StoryDao {

	NamedParameterJdbcTemplate template;
	
	public StoryDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public List<Story> getStories(int offset, int limit) {
		MapSqlParameterSource parametersMap = new MapSqlParameterSource("offset", offset);
		parametersMap.addValue("limit", limit);
		return template.query("SELECT s.id, s.name FROM wf_manager.stories s \r\n"
				+ "ORDER BY start_date ASC \r\n"
				+ "LIMIT :limit OFFSET :offset;", parametersMap, new StoryMapper());
	}

	@Override
	public Story getStory(BigInteger id) {
		MapSqlParameterSource parametersMap = new MapSqlParameterSource("id", id);
		List<Story> s = template.query("SELECT s.id, s.name FROM wf_manager.stories s \r\n"
				+ "where s.id = :id;",
				parametersMap, new StoryMapper());
		if (s.size() > 0) {
			return s.get(0);
		}
		return null;
	}
	
	@Override
	public void createStory(Story story) {
		SqlParameterSource parametersMap = new MapSqlParameterSource("id", story.getId())
				.addValue("name", story.getName())
				.addValue("description", story.getDescription());
		template.execute("insert into wf_manager.stories(\"id\", \"name\", \"description\", \"start_date\", \"end_date\")\r\n"
				+ "values(:id,:name, :description, null, null);", parametersMap, 
				new PreparedStatementCallback<Void>() {
		            @Override
		            public Void doInPreparedStatement(PreparedStatement ps) throws SQLException {
		                // You can set additional parameters or perform operations here
		                ps.executeUpdate();
		                return null;
		            }
		        });
	}

}
