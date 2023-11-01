package cgv;

public class MyPage {
    private String name;
    private String id;
    private String pw;
    private String address;
    private String phone;
    private int mileage;

    public MyPage() {
    }

    public MyPage(String name, String id, String pw, String address, String phone, int mileage) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.address = address;
        this.phone = phone;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "MyPage{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
