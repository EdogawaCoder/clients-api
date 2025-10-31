package com.edogawa.apiClients.repositories;

import com.edogawa.apiClients.entities.Client;
import com.edogawa.apiClients.factories.ConnectionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ClientRepository {

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public void insertClient(Client client) throws Exception {

        var connection = connectionFactory.getConnection();

        var query = """
                INSERT INTO clients
                    (id, name, email, cpf, phone, born_date, register_date)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        var preparedStatement = connection.prepareStatement(query);


        preparedStatement.setObject(1, client.getId());
        preparedStatement.setString(2, client.getName());
        preparedStatement.setString(3, client.getEmail());
        preparedStatement.setString(4, client.getCpf());
        preparedStatement.setString(5, client.getPhone());
        preparedStatement.setDate(6, new java.sql.Date(client.getDateBorn().getTime()));
        preparedStatement.setDate(7, new java.sql.Date(client.getDateRegist().getTime()));

        preparedStatement.execute();

        connection.close();
    }

    public Boolean updateClient(Client client) throws Exception {

        var connection = connectionFactory.getConnection();

        var query = """
                UPDATE clients
                SET
                name = ?,
                email = ?,
                cpf = ?,
                phone = ?,
                date_born = ?
                WHERE
                    id = ?;
                """;

        var preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getEmail());
        preparedStatement.setString(3, client.getCpf());
        preparedStatement.setString(4, client.getPhone());
        preparedStatement.setDate(5, new java.sql.Date(client.getDateBorn().getTime()));
        preparedStatement.setObject(6, client.getId());

        var rowsAffected = preparedStatement.executeUpdate();

        connection.close();

        return rowsAffected > 0;


    }

    public Boolean deleteClient(UUID id) throws Exception {

        var connection = connectionFactory.getConnection();

        var query = """
                DELETE FROM clients
                WHERE id=?
                """;

        var statement = connection.prepareStatement(query);
        statement.setObject(1, id);
        var rowsAffected = statement.executeUpdate();

        connection.close();

        return rowsAffected > 0;


    }


    public List<Client> searchClients(String name) throws Exception {

        var connection = connectionFactory.getConnection();

        var query = """
                SELECT id, name, email, cpf, phone, date_born, date_regist
                FROM clients
                WHERE name ILIKE ?
                ORDER BY name ASC;
                """;

        var statement = connection.prepareStatement(query);

        statement.setString(1, "%" + name + "%");

        var resultSet = statement.executeQuery();

        var clients = new ArrayList<Client>();

        while (resultSet.next()) {
            var client = new Client();
            client.setId(UUID.fromString(resultSet.getString("id")));
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            client.setCpf(resultSet.getString("cpf"));
            client.setPhone(resultSet.getString("phone"));
            client.setDateBorn(new Date(resultSet.getDate("date_born").getTime()));
            client.setDateRegist(new Date(resultSet.getDate("date_regist").getTime()));

            clients.add(client);
        }

        connection.close();

        return clients;

    }

    public Client getClientById(UUID id) throws Exception {

        var connection = connectionFactory.getConnection();

        var query = """
                SELECT id, name, email, cpf, phone, date_born, date_regist
                FROM clients
                WHERE id = ?;
                """;

        var statement = connection.prepareStatement(query);

        statement.setObject(1, id);

        var resultSet = statement.executeQuery();

        Client client = null;

        if (resultSet.next()) {
            client = new Client();
            client.setId(UUID.fromString(resultSet.getString("id")));
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            client.setCpf(resultSet.getString("cpf"));
            client.setPhone(resultSet.getString("phone"));
            client.setDateBorn(new Date(resultSet.getDate("born_date").getTime()));
            client.setDateRegist(new Date(resultSet.getDate("date_regist").getTime()));


        }

        connection.close();

        return client;

    }
}
