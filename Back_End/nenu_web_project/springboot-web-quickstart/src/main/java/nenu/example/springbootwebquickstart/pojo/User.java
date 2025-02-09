package nenu.example.springbootwebquickstart.pojo;

public class User {
    private String name;
    private int age;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address addres) {
        this.address = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addres=" + address +
                '}';
    }
}
