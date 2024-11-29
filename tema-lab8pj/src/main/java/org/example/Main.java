package org.example;

import java.sql.*;
import java.util.Scanner;

        public class Main {
            public class DatabaseConnection {
                public static Connection getConnection() throws SQLException {
                    String url = "jdbc:mysql://localhost:3306/lab8pj";
                    return DriverManager.getConnection(url, "root", "Albastru12");
                }
            }


            public static void adaugaPersoana(Scanner scanner) {
                System.out.print("Introduceți numele persoanei: ");
                String nume = scanner.nextLine();

                int varsta = 0;
                while (true) {
                    try {
                        System.out.print("Introduceți vârsta persoanei: ");
                        varsta = Integer.parseInt(scanner.nextLine());
                        if (varsta < 0 || varsta > 150) {
                            throw new ExceptieVarsta("Vârsta nu este validă!");
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vă rugăm să introduceți un număr valid pentru vârstă.");
                    } catch (ExceptieVarsta e) {
                        System.out.println(e.getMessage());
                    }
                }

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "INSERT INTO persoane (nume, varsta) VALUES (?, ?)";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setString(1, nume);
                        stmt.setInt(2, varsta);
                        stmt.executeUpdate();
                        System.out.println("Persoana a fost adăugată.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static void adaugaExcursie(Scanner scanner) {
                System.out.print("Introduceți ID-ul persoanei care face excursia: ");
                int idPersoana = scanner.nextInt();
                scanner.nextLine();


                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "SELECT * FROM persoane WHERE idpersoane = ?";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setInt(1, idPersoana);
                        ResultSet rs = stmt.executeQuery();

                        if (!rs.next()) {
                            System.out.println("Persoana nu există.");
                            return;
                        }


                        System.out.print("Introduceți destinația excursiei: ");
                        String destinatia = scanner.nextLine();

                        int an = 0;
                        while (true) {
                            try {
                                System.out.print("Introduceți anul excursiei: ");
                                an = Integer.parseInt(scanner.nextLine());
                                if (an < 1900 || an > 2024) {
                                    throw new ExceptieAnExcursie("Anul nu este valid.");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Vă rugăm să introduceți un număr valid pentru an.");
                            } catch (ExceptieAnExcursie e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        query = "INSERT INTO excursii (id_persoane, destinatie, anul) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtInsert = con.prepareStatement(query)) {
                            stmtInsert.setInt(1, idPersoana);
                            stmtInsert.setString(2, destinatia);
                            stmtInsert.setInt(3, an);
                            stmtInsert.executeUpdate();
                            System.out.println("Excursia a fost adăugată.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            public static void afiseazaPersoaneSiExcursii() {
                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "SELECT p.nume, p.varsta, e.destinatie, e.anul FROM persoane p " +
                            "LEFT JOIN excursii e ON p.idpersoane = e.id_persoane";
                    try (Statement stmt = con.createStatement()) {
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            System.out.println("Nume: " + rs.getString("nume") +
                                    ", Vârstă: " + rs.getInt("varsta") +
                                    ", Destinație: " + rs.getString("destinatie") +
                                    ", Anul excursiei: " + rs.getInt("anul"));
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            public static void afiseazaExcursiiPentruPersoana(Scanner scanner) {
                System.out.print("Introduceți numele persoanei: ");
                String nume = scanner.nextLine();

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "SELECT e.destinatie, e.anul FROM excursii e " +
                            "JOIN persoane p ON e.id_persoane = p.idpersoane WHERE p.nume = ?";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setString(1, nume);
                        ResultSet rs = stmt.executeQuery();
                        boolean found = false;
                        while (rs.next()) {
                            System.out.println("Destinație: " + rs.getString("destinatie") +
                                    ", Anul excursiei: " + rs.getInt("anul"));
                            found = true;
                        }
                        if (!found) {
                            System.out.println("Nu există excursii pentru persoana respectivă.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            public static void afiseazaPersoanePentruDestinatie(Scanner scanner) {
                System.out.print("Introduceți destinația: ");
                String destinatia = scanner.nextLine();

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "SELECT p.nume FROM persoane p " +
                            "JOIN excursii e ON p.idpersoane = e.id_persoane WHERE e.destinatie = ?";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setString(1, destinatia);
                        ResultSet rs = stmt.executeQuery();
                        boolean found = false;
                        while (rs.next()) {
                            System.out.println("Persoană: " + rs.getString("nume"));
                            found = true;
                        }
                        if (!found) {
                            System.out.println("Nu există persoane care au vizitat această destinație.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static void afiseazaPersoanePentruAn(Scanner scanner) {
                System.out.print("Introduceți anul: ");
                int an = scanner.nextInt();
                scanner.nextLine();

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "SELECT p.nume FROM persoane p " +
                            "JOIN excursii e ON p.idpersoane = e.id_persoane WHERE e.anul = ?";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setInt(1, an);
                        ResultSet rs = stmt.executeQuery();
                        boolean found = false;
                        while (rs.next()) {
                            System.out.println("Persoană: " + rs.getString("nume"));
                            found = true;
                        }
                        if (!found) {
                            System.out.println("Nu există persoane care au făcut excursii în acest an.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static void stergeExcursie(Scanner scanner) {
                System.out.print("Introduceți ID-ul excursiei de șters: ");
                int idExcursie = scanner.nextInt();
                scanner.nextLine();

                try (Connection con = DatabaseConnection.getConnection()) {
                    String query = "DELETE FROM excursii WHERE id_excursie = ?";
                    try (PreparedStatement stmt = con.prepareStatement(query)) {
                        stmt.setInt(1, idExcursie);
                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Excursia a fost ștearsă.");
                        } else {
                            System.out.println("Excursia nu a fost găsită.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            public static void stergePersoana(Scanner scanner) {
                System.out.print("Introduceți ID-ul persoanei de șters: ");
                int idPersoana = scanner.nextInt();
                scanner.nextLine();

                try (Connection con = DatabaseConnection.getConnection()) {

                    String deleteExcursii = "DELETE FROM excursii WHERE id_persoane = ?";
                    try (PreparedStatement stmt = con.prepareStatement(deleteExcursii)) {
                        stmt.setInt(1, idPersoana);
                        stmt.executeUpdate();
                    }

                    // Șterge persoana
                    String deletePersoana = "DELETE FROM persoane WHERE idpersoane = ?";
                    try (PreparedStatement stmt = con.prepareStatement(deletePersoana)) {
                        stmt.setInt(1, idPersoana);
                        stmt.executeUpdate();
                        System.out.println("Persoana și excursiile sale au fost șterse.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("\nMeniu:");
                    System.out.println("1. Adaugă persoană");
                    System.out.println("2. Adaugă excursie");
                    System.out.println("3. Afișează persoane și excursii");
                    System.out.println("4. Afișează excursii pentru o persoană");
                    System.out.println("5. Afișează persoane care au vizitat o destinație");
                    System.out.println("6. Afișează persoane care au făcut excursii într-un anumit an");
                    System.out.println("7. Șterge excursie");
                    System.out.println("8. Șterge persoană și excursiile sale");
                    System.out.println("9. Ieșire");
                    System.out.print("Alegeți opțiunea: ");
                    int optiune = scanner.nextInt();
                    scanner.nextLine();

                    switch (optiune) {
                        case 1:
                            adaugaPersoana(scanner);
                            break;
                        case 2:
                            adaugaExcursie(scanner);
                            break;
                        case 3:
                            afiseazaPersoaneSiExcursii();
                            break;
                        case 4:
                            afiseazaExcursiiPentruPersoana(scanner);
                            break;
                        case 5:
                            afiseazaPersoanePentruDestinatie(scanner);
                            break;
                        case 6:
                            afiseazaPersoanePentruAn(scanner);
                            break;
                        case 7:
                            stergeExcursie(scanner);
                            break;
                        case 8:
                            stergePersoana(scanner);
                            break;
                        case 9:
                            System.out.println("Ieșire...");
                            return;
                        default:
                            System.out.println("Opțiune invalidă.");
                    }
                }
            }
        }

