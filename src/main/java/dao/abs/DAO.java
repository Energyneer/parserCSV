package dao.abs;

import dao.DBException;
import unit.Unit;

import java.util.List;

public interface DAO {

    default boolean checkParameters(String login, String password) {
        if (login.isEmpty() || password.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public long insertUser(String login, String password, String name) throws DBException;

    public Unit getUser(long id) throws DBException;

    public List<Unit> getAllUsers() throws DBException;

    public List<Unit> getUsersByParam(String param, String value) throws DBException;

    public long updateUser(long id, String newLogin, String curPassword, String newPassword,
                           String newName) throws DBException;

    public long deleteUser(long id) throws DBException;
}