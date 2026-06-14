package com.readstat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.readstat.DAOs.UserDAO;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void loginDAO() {
        UserDAO userDAO = new UserDAO();
        assertTrue(userDAO.verifyLogin("linnea", "123"));
    }

    @Test
    // after the first time this is run, it will run false since it's attempting to add a primary key identical to an existing one
    public void createUser() {
        UserDAO userDAO = new UserDAO();
        assertFalse(userDAO.createUser("yayme", "123"));
    }
}
