package tinder.dao;

import tinder.models.User;

import java.sql.*;

public class UserStorageDB implements InterfaceDAO<User> {

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

}
