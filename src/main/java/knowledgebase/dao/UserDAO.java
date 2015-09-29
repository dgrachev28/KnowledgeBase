package knowledgebase.dao;

import java.util.List;

import knowledgebase.domain.User;

public interface UserDAO {

    public User getUserByLoginPassword(String login, String password);

}