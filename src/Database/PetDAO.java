package Database;

import java.sql.*;

public class PetDAO {

    public void getAllPets() {
        String sql = "SELECT * FROM animal";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ВСЕ ЖИВОТНЫЕ ИЗ БАЗЫ ДАННЫХ ---");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("animal_id") +
                        " | Кличка: " + resultSet.getString("name") +
                        " | Вид: " + resultSet.getString("species") +
                        " | Возраст: " + resultSet.getInt("age") +
                        " | Владелец: " + resultSet.getString("owner_name"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void insertPet(String name, String species, int age, String ownerName) {
        String sql = "INSERT INTO animal (name, species, age, owner_name) VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, species);
            statement.setInt(3, age);
            statement.setString(4, ownerName);
            statement.executeUpdate();
            statement.close();
            System.out.println("Животное успешно добавлено!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean updatePet(int id, String name, int age) {
        String sql = "UPDATE animal SET name = ?, age = ? WHERE animal_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public boolean deletePet(int id) {
        String sql = "DELETE FROM animal WHERE animal_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByName(String name) {
        String sql = "SELECT * FROM animal WHERE name ILIKE ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- РЕЗУЛЬТАТЫ ПОИСКА ---");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("animal_id") +
                        " | Кличка: " + resultSet.getString("name") +
                        " | Вид: " + resultSet.getString("species") +
                        " | Возраст: " + resultSet.getInt("age"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByAgeRange(int min, int max) {
        String sql = "SELECT * FROM animal WHERE age BETWEEN ? AND ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, min);
            statement.setInt(2, max);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ЖИВОТНЫЕ В ВОЗРАСТЕ ОТ " + min + " ДО " + max + " ---");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("animal_id") +
                        " | Кличка: " + resultSet.getString("name") +
                        " | Возраст: " + resultSet.getInt("age"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void searchByMinAge(int minAge) {
        String sql = "SELECT * FROM animal WHERE age >= ?";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ЖИВОТНЫЕ СТАРШЕ " + minAge + " ЛЕТ ---");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("animal_id") +
                        " | Кличка: " + resultSet.getString("name") +
                        " | Возраст: " + resultSet.getInt("age"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}