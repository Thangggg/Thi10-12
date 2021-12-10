package Model;

public class User {
    private String name;
    private String numberPhone;
    private String address;
    private String email;
    private String facebook;
    private String group;
    private String gender;

    public User() {
    }

    public User(String name, String numberPhone, String address, String email, String facebook,String group, String gender) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
        this.group = group;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return name + "," + numberPhone + "," + address + "," + email + "," + facebook + "," + group + "," + gender;
    }
}
