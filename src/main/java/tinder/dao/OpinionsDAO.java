package tinder.dao;
// tesst 11looo
import tinder.models.Opinion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpinionsDAO implements InterfaceDAO<Opinion>{
    @Override
    public Opinion get(int user_id) {
        Opinion opinion = new Opinion();

        String sql = "SELECT * FROM erom_opinions WHERE user_id='" + user_id + "'";

        try (
                Connection connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                opinion.setUserId(rSet.getInt("user_id"));
                opinion.setLikedUserId(rSet.getInt("liked_user_id"));
                opinion.setLike(rSet.getInt("like"));

                return opinion;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Opinion opinion) {
        String sql = "INSERT INTO erom_opinions (user_id, liked_user_id, \"like\") VALUES (?,?,?)";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, opinion.getUserId());
            statement.setInt(2, opinion.getLikedUserId());
            statement.setInt(3, opinion.getLike());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Opinion opinion) {
        String sql = "UPDATE erom_opinions SET like=? WHERE user_id=?";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, opinion.getLike());
            statement.setInt(2, opinion.getUserId());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int user_id) {
        String sql = "DELETE FROM erom_opinions WHERE user_id=?";

        try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1, user_id);
            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
