package builder;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Фамилия не может быть пустой");
        }

        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }

        this(name, surname);
        this.age = age;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return age == null ? OptionalInt.empty() : OptionalInt.of(age);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age != null) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(0)
                .setAddress(this.address)
                .setSurname(this.surname);
    }

    @Override
    public String toString() {
        return name + " " + surname +
                (age != null ? ", возраст: " + age : "") +
                (address != null ? ", проживает в: " + address : "");
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + age.hashCode() + address.hashCode();
    }
}
