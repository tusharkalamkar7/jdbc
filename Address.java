import java.util.Date;

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
  
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Date getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public Integer getCreatedId() {
		return createdId;
	}
	public void setCreatedId(Integer createdId) {
		this.createdId = createdId;
	}
	public Integer getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(Integer updatedId) {
		this.updatedId = updatedId;
	}

}
