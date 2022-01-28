package com.adventures.others;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCode {

    public static void main(String[] args) {

        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");

        System.out.println(p1.equals(p2));

        System.out.println(Objects.equals(p1, p2));
        System.out.println("p1 hash code: " + p1.hashCode());
        System.out.println("p2 hash code: " + p2.hashCode());

        Set<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);

        System.out.println("Set size: " + players.size());
        System.out.println("Set contains Rafael Nadal: "
                + players.contains(new Player(1, "Rafael Nadal")));
    }
}

class Player {

    private int id;
    private String name;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

