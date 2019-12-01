package pojo;

public class Member
{
	private int bId;
	private float bPrice;
	private String bName, bAuthor, bSubject, bStatus;
	
	public Member()
	{  }

	public Member(String bName, String bAuthor, String bSubject, float bPrice,  String bStatus) {
		super();
		
		
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bSubject = bSubject;
		this.bPrice = bPrice;
		this.bStatus = bStatus;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public float getbPrice() {
		return bPrice;
	}

	public void setbPrice(float bPrice) {
		this.bPrice = bPrice;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbSubject() {
		return bSubject;
	}

	public void setbSubject(String bSubject) {
		this.bSubject = bSubject;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}
	
	public String toString()
	{
		return  String.format("%-20s%-20s%-20s%-10.2f%-20s\n", this.bName, this.bAuthor, this.bSubject,  this.bPrice, this.bStatus);
	}
	
	
}		