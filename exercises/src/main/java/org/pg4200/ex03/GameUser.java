package org.pg4200.ex03;

import java.util.Comparator;
import java.util.Objects;

public class GameUser implements Comparator<GameUser>, Comparable<GameUser> {

    private String userId;

    private int points;

    public GameUser(String userId, int points) {
        this.userId = Objects.requireNonNull(userId);
        this.points = points;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public int compareTo(GameUser o) {
        if (o.getClass() != this.getClass()) throw new IllegalArgumentException("Must compare with objects of same class");
        GameUser gu = (GameUser) o;
        return this.points - gu.points;
    }

    public int compare(GameUser o1, GameUser o2) {
        return o1.points - o2.points;
    }
}
