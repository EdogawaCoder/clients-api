package com.edogawa.apiClients.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() throws Exception {

        var host = "jdbc:postgresql://localhost:5432/db_apiClients";
        var user = "postgres";
        var pass = "password";


        return DriverManager.getConnection(host, user, pass);


    }

}
