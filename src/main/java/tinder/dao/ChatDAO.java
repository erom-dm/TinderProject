/*package tinder.dao;

import tinder.models.User;

import java.sql.*;

public class ChatDAO implements InterfaceDAO<Chat> {

    @Override
    public void save(Chat chat)
    {
        String sql = "INSERT INTO chat(chat_id, messages) VALUES(?,?)";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            statement.setInt(1, chat.getChatId());
            //statement.setCollection(2, chat.getData());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override public void update(Chat chat)
    {
        String sql = "UPDATE chat SET messages=? WHERE chat_id=?";

        try ( Connection connection = ConnectionToDB.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); )
        {
            //statement.setCollection(1, chat.getData());
            statement.setString(2, chat.getChatId());

            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public Chat get(int chatId)
    {
        Chat chat = new Chat();

        String sql = "SELECT * FROM chat WHERE chat_id='" + chatId + "'";

        try (
                Connection        connection  = ConnectionToDB.getConnection();
                PreparedStatement statement  = connection.prepareStatement(sql);
                ResultSet rSet = statement.executeQuery();
        )
        {
            while ( rSet.next() )
            {
                chat.setChatId(rSet.getInt("chat_id"));
                //chat.setData(rSet.getCollection("messages"));
               

                return user;
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int chatId)
    {
        String sql = "DELETE FROM chat WHERE chat_id=?";

        try (
                Connection connection = ConnectionToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1, chatId);
            statement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

}*/
