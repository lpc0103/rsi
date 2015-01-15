package lpc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UapMenuResource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uap_menu_resource")
public class UapMenuResource implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuid;
	private String parentmenuid;
	private String name;
	private String location;
	private String enable;
	private String removed;

	// Constructors

	/** default constructor */
	public UapMenuResource() {
	}

	/** minimal constructor */
	public UapMenuResource(String menuid) {
		this.menuid = menuid;
	}

	/** full constructor */
	public UapMenuResource(String menuid, String parentmenuid, String name,
			String location, String enable, String removed) {
		this.menuid = menuid;
		this.parentmenuid = parentmenuid;
		this.name = name;
		this.location = location;
		this.enable = enable;
		this.removed = removed;
	}

	// Property accessors
	@Id
	@Column(name = "menuid", unique = true, nullable = false, length = 16)
	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	@Column(name = "parentmenuid", length = 16)
	public String getParentmenuid() {
		return this.parentmenuid;
	}

	public void setParentmenuid(String parentmenuid) {
		this.parentmenuid = parentmenuid;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "location", length = 100)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "enable", length = 100)
	public String getEnable() {
		return this.enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Column(name = "removed", length = 100)
	public String getRemoved() {
		return this.removed;
	}

	public void setRemoved(String removed) {
		this.removed = removed;
	}

}