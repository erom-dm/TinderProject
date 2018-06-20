package tinder.dao;

import tinder.models.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesDAO implements InterfaceDAO<Message> {
    @Override
    public Message get(int user_id_1) {
        Message message = new Message();

        String sql = "SELECT * FROM erom_messages WHERE user_id_1='" + user_id_1 + "'";

        try (
                Connection connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                message.setUserId1(rSet.getInt("user_id_1"));
                message.setUserId2(rSet.getInt("user_id_2"));
                message.setText(rSet.getString("text"));
                message.setTime(rSet.getLong("time"));

                return message;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO erom_messages(user_id_1, user_id_2, text, time) VALUES(?,?,?,?)";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, message.getUserId1());
            statement.setInt(2, message.getUserId2());
            statement.setString(3, message.getText());
            statement.setLong(4, message.getTime());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Message message) {
        String sql = "UPDATE erom_messages SET text=?, time=? WHERE user_id_1=?";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setString(1, message.getText());
            statement.setLong(2, message.getTime());
            statement.setInt(3, message.getUserId1());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int user_id_1) {
        String sql = "DELETE FROM erom_messages WHERE user_id_1=?";

        try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1, user_id_1);
            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
