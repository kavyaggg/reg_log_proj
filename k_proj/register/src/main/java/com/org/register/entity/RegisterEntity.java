package com.org.register.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import com.org.register.dao.ForgotDAOImpl;



@Entity
@Table(name="registerForm")

@NamedQueries({@NamedQuery(name = "updatePasswordByEmail", query = "update RegisterEntity re set re.password=:password where re.email=:email")
		 ,@NamedQuery(name = "fetchByEmail", query = "select re from RegisterEntity re where re.email=:email")
	,@NamedQuery(name="fetchByEmailAndPassword", query="select re from RegisterEntity re where re.email=:email and re.password=:password")})

//@NamedQuery(name="fetchByEmailAndPassword", query="select re from RegisterEntity re where re.email=:mail and re.password=:pwd")
public class RegisterEntity implements Serializable {
	private static Logger logger = Logger.getLogger(ForgotDAOImpl.class);

	
	
	@Id
	@GenericGenerator(name = "madhu", strategy = "increment")
	@GeneratedValue(generator="madhu")
	@Column(name="id")
	private int id;
	@Column(name="userName")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="phnNum")
	private long phnNum;
	@Column(name="password")
	private String password;
	
	public RegisterEntity() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhnNum() {
		return phnNum;
	}

	public void setPhnNum(long phnNum) {
		this.phnNum = phnNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", userName=" + userName + ", email=" + email + ", phnNum=" + phnNum
				+ ", password=" + password + "]";
	}
	
}
