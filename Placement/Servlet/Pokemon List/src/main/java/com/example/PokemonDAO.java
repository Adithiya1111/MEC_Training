package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/pokelist";
    private static final String USER = "root";
    private static final String PASS = "@Root!";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found", e);
        }
    }

    public void addPokemon(String name, String rarity) {
        String sql = "INSERT INTO pokemon(name, rarity) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, rarity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting pokemon", e);
        }
    }

    public List<Pokemon> listPokemon() {
        String sql = "SELECT id, name, rarity FROM pokemon ORDER BY id DESC";
        List<Pokemon> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Pokemon(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("rarity")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching pokemon details", e);
        }
        return list;
    }

    public void delPokemon(String name) {
        String sql = "DELETE FROM pokemon WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting pokemon", e);
        }
    }

    public void updPokemon(String name, String rarity, int id) {
        String sql = "UPDATE pokemon SET name=?, rarity=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, rarity);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating pokemon", e);
        }
    }
}

