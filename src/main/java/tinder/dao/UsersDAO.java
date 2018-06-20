package tinder.dao;

import tinder.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements InterfaceDAO<User> {

    @Override
    public void save(User user)
    {
        String sql = "INSERT INTO erom_users(id, name, pic_url, gender) VALUES(?,?,?,?)";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserPicURL());
            statement.setString(3, user.getGender());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int userId)
    {
        User user = new User();

        String sql = "SELECT * FROM erom_users WHERE id='" + userId + "'";

        try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                user.setUserId(rSet.getInt("id"));
                user.setUserName(rSet.getString("name"));
                user.setUserPicURL(rSet.getString("pic_url"));
                user.setGender(rSet.getString("gender"));

                return user;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public void update(User user)
    {
        String sql = "UPDATE erom_users SET name=?, pic_url=? WHERE id=?";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPicURL());
            statement.setInt(3, user.getUserId());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int userId)
    {
        String sql = "DELETE FROM erom_users WHERE id=?";

        try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public List<User> getAll(){
        User user = new User();
        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM erom_users";

        try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                user.setUserId(rSet.getInt("id"));
                user.setUserName(rSet.getString("name"));
                user.setUserPicURL(rSet.getString("pic_url"));
                user.setGender(rSet.getString("gender"));

                list.add(user);
            }
            return list;
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    public User getFirstUnseen(String gender){
        User user = new User();

        String sql = "Select min(erom_users.id), name, pic_url, gender " +
                "FROM erom_users LEFT JOIN erom_opinions on erom_opinions.liked_user_id = erom_users.id " +
                "WHERE erom_opinions.like is null and erom_users.gender = '"+ gender +"'";

        try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                user.setUserId(rSet.getInt("min(erom_users.id)"));
                user.setUserName(rSet.getString("name"));
                user.setUserPicURL(rSet.getString("pic_url"));
                user.setGender(rSet.getString("gender"));

                return user;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
