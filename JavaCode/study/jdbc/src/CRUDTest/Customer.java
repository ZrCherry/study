package CRUDTest;

import java.util.Date;

/**
 * ClassName: Customer
 * Package: CRUDTest
 * Description:
 *
 * @Author cherry
 * @Create 2023/8/2 10:52
 * @Version 1.0
 */
public class Customer {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", photo='" + photo + '\'' +
                '}';
    }

    private int id;
    private String name;
    private String email;
    private Date birth;
    private byte[] photo;


    public Customer() {
    }
}
