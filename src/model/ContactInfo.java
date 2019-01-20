package model;

public class ContactInfo {
    public enum City{
        AddisAbaba("Addis Ababa"),
        BahirDar("Bahir Dar"),
        DireDawa("Dire Dawa");

        private final String name;
        City(String s){
            this.name=s;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    class Customer{
        AuthInfo authInfo;

        boolean Login(AuthInfo info){
            //Ye fitsum function Fitsum.login()
            if(Fitsum.login(contactInfo)){
                contactInfo==contactInfo;
            }
        }
    }

    private String firstName;
    private String lastName;
    private City city;
    private String phone;
    private String username;
    private String password;

    public ContactInfo(String firstName, String lastName, City city, String phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public City getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
