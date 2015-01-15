package lpc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uap_user")
public class UapUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	// Fields

	private Integer userid;
	private String loginname;
	private String password;
	private String name;
	private String enable;
	private String removed;

	// Constructors

	/** default constructor */
	public UapUser() {
	}

	/** minimal constructor */
	public UapUser(Integer userid) {
		this.userid = userid;
	}

	/** full constructor */
	public UapUser(Integer userid, String loginname, String password,
			String name, String enable, String removed) {
		this.userid = userid;
		this.loginname = loginname;
		this.password = password;
		this.name = name;
		this.enable = enable;
		this.removed = removed;
	}

	// Property accessors
	@Id
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "loginname", length = 100)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "enable", length = 1)
	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Column(name = "removed", length = 1)
	public String getRemoved() {
		return this.removed;
	}

	public void setRemoved(String removed) {
		this.removed = removed;
	}

}