package ru.kuper;

public class User {

    private long id;
    private String name;
    private int age;
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        return result = prime * result + ((getName() == null) ? 0 : name.hashCode()) + (getSex() == null ? 0 : getSex().hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass() || obj == null) return false;
        User user = (User) obj;
        return (user.getSex() == this.getSex() & user.getName() == this.getName() & user.getAge() == this.getAge());
    }


}
