package learning.java;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private int age;
    private String userId;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.userId = "default_id";
    }

    public User(String name, int age, String userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", userId='" + userId + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, userId);
    }
}
