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

        if (getTryCatch(user, sql)) return user;
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

    public boolean loginValidation(String email, String password){
        User user = new User();

        String sql = "SELECT * FROM erom_users WHERE email='" + email + "'";

        try (
                Connection connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery()
        )
        {
            while ( rSet.next() )
            {
                user.setUserId(rSet.getInt("id"));
                user.setUserName(rSet.getString("name"));
                user.setUserPicURL(rSet.getString("pic_url"));
                user.setGender(rSet.getString("gender"));
                user.setPassword(rSet.getString("password"));
                user.setEmail(rSet.getString("email"));
            }
            if(user.getPassword().equals(password)) return true;

        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAllLiked(int currentUserId){
        List<User> list = new ArrayList<>();

        String sql =
        "SELECT U.* FROM erom_users as U "+
        "LEFT JOIN erom_opinions as O ON O.liked_user_id = U.id "+
        "WHERE O.user_id = '"+ currentUserId +"' and O.like = 1; ";


        try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                User user = new User();
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

    public User getFirstUnseen(String gender, int logged_userId){
        User user = new User();

        String sql =
        "SELECT users.id, users.name, users.pic_url, users.gender " +
        "FROM erom_users AS users " +
        "LEFT JOIN erom_opinions ON erom_opinions.liked_user_id = users.id " +
        "WHERE " +
        "users.gender = '"+ gender + "' " +
        "AND " +
        "NOT users.id in " +
        "(SELECT id FROM erom_users " +
        "LEFT JOIN erom_opinions ON erom_opinions.liked_user_id = erom_users.id " +
        "WHERE erom_opinions.user_id = '"+ logged_userId +"') " +
        "LIMIT 1;";


        if (getTryCatch(user, sql)) return user;
        return null;
    }

    private boolean getTryCatch(User user, String sql) {
        try (
                Connection connection  = ConnectionToDB.getConnection();
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

                return true;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return false;
    }
}
