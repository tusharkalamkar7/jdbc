public class Address {

    private Integer id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private Integer pincode;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Integer createdId;
    private Integer updatedId;

    public Address() {
    }
    public Address(String line1,String line2,String city,String state, Integer pincode,Date createdDateTime,Date updatedDateTime,Integer createdId,Integer updatedId) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
	this.state = state;
	this.pincode=pincode;
	this.createdDateTime=createdDateTime;
	this.updatedDateTime=updatedDateTime;
	this.createdId=createdId;
	this.updatedId=updatedId;
    }
  
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}