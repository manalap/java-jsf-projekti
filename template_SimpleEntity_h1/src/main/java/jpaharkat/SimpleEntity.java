package jpaharkat;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SimpleEntity
 * 
 */
@Entity
@Table(name = "SIMPLEENTITY")
@NamedQuery(name = "selectAll", query = "SELECT a from SimpleEntity a")
public class SimpleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String desc;

	public SimpleEntity() {
		super();
		this.name = "kuka?";
		this.desc = "tyhjä";
	}
	

	
	public SimpleEntity(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public void setDesc(String desc){
		this.desc = desc;
		
	}
	public String getDesc(){
		return this.desc;
	}



	@Override
	public String toString() {
		return "SimpleEntity [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	
	
}
