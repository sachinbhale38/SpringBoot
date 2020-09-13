package com.ingecno.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uId;
	private String userName;
	private String password;

	private transient Long roleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "r_Id")
	private Role role;

	@JsonIgnoreProperties("user")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Address.class, mappedBy = "user")
	private Set<Address> addresses = new HashSet<Address>();

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Users(String userName, String password, Role role, Set<Address> addresses) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Users [uId=" + uId + ", userName=" + userName + ", password=" + password + ", rId=" + roleId + ", role="
				+ role + ", addresses=" + addresses + "]";
	}

	public Long getRoleId() {
		return role.getrId();
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
