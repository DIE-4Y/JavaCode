package com.nenu.generic_;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<User> ud = new DAO<>();
        ud.save("1001", new User(1001, "Jack"));
        ud.save("1002", new User(1002, "Marry"));
        ud.save("1003", new User(1003, "Smith"));
        System.out.println(ud.list());

        System.out.println(ud.get("1001"));;
        System.out.println(ud.list());

        ud.update("1002", new User(1002, "ZhangSan"));
        System.out.println(ud.list());

        ud.delete("1003");
        System.out.println(ud.list());
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class DAO<T> {
    private HashMap<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        ArrayList<T> ts = new ArrayList<>();
        Collection<T> values = map.values();
        Iterator<T> iterator = values.iterator();
        while (iterator.hasNext()) {
            T next =  iterator.next();
            ts.add(next);
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }
}