package com.sg.jdbctcomplexexample.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kylerudy
 */
public class Room {
    int id;
    String name;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class RoomMapper implements RowMapper<Room> {
        @Override
        public Room mapRow(ResultSet resultSet, int i) throws SQLException {
            Room rm = new Room();
            rm.setId(resultSet.getInt("id"));
            rm.setName(resultSet.getString("name"));
            rm.setDescription(resultSet.getString("description"));
            return rm;
        }
    }
}