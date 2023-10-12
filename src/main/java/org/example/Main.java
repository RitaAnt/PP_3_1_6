package org.example;


public class Main {

    public static void main(String[] args) {
        Connect connect = new Connect();
        System.out.println(connect.getUsers());
        User userToAdd = new User(3L, "Bob", "Kelso", (byte) 55);
        System.out.println(connect.save(userToAdd));
        User userToPatch = new User(3L, "Jonathan", "Dorian", (byte) 25);
        System.out.println(connect.patch(userToPatch));
        System.out.println(connect.delete(3L));
        System.out.println(connect.getUsers());
    }

}