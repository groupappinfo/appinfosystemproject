package cn.appsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class BackendUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4541441966802533190L;
	private int id;
	private String userCode;
	private String userName;
	private int userType;
	private int createdBy;
	private Date creationDate;
	private int modifyBy;
	private Date modifyDate;
	private String userPassword;
	private String userTypeName;
<<<<<<< HEAD
<<<<<<< HEAD
	
	
=======
=======
>>>>>>> 75bbbe8349a7cdf30a68a7201daa9f917859095e
	private String valueName;
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
<<<<<<< HEAD
>>>>>>> 75bbbe8349a7cdf30a68a7201daa9f917859095e
=======
>>>>>>> 75bbbe8349a7cdf30a68a7201daa9f917859095e
	public BackendUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public BackendUser(int id, String userCode, String userName, int userType,
			int createdBy, Date creationDate, int modifyBy, Date modifyDate,
			String userPassword) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userType = userType;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userPassword = userPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
