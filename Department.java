public class Department {

    private Integer deptId;
    private String deptName;
    private Date createdDateTime;
    private Date updatedDateTime;
    private Integer createdId;
    private Integer updatedId;

    public Department() {
    }
    public Department(String deptName, Date createdDateTime,Date updatedDateTime,Integer createdId,Integer updatedId) {
        this.deptName = deptName;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
	this.createdId = createdId;
	this.updatedId = updatedId;
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