package de.msg.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Author")
public class Author {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	  @GenericGenerator(name = "native", strategy = "native")
	  @Column(name = "ID")
	  private Long authorId;
	  
	  @Column(name = "FIRSTNAME")
	  private String firstName;
	  
	  @Column(name = "LASTNAME")
	  private String lastName;
	  
	  public void setAuthorId(Long authorId) {
		  this.authorId = authorId;
	  }
	  
	  public Long getAuthorId() {
		  return authorId;
	  }
	  
	  public void setFirstName(String firstName) {
		  this.firstName = firstName;
	  }
	  
	  public String getFirstName() {
		  return firstName;
	  }
	  
	  public void setLastName(String lastName) {
		  this.lastName = lastName;
	  }
	  
	  public String getLastName() {
		  return lastName;
	  }
	  
	  @Override
	  public String toString() {
		return (authorId + "\t" + firstName + "\t" + lastName);
	  }
	
}
