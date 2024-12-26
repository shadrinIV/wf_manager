package com.shadrin.wf_manager.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.shadrin.wf_manager.entity.*;

public class StoryMapper implements RowMapper<Story> {

	
	@Override
	public Story mapRow(ResultSet rs, int rowNum) throws SQLException {
		Story s = new StoryImpl(BigInteger.valueOf(rs.getLong("id")), rs.getString("name"));
		return s;
	}

}
