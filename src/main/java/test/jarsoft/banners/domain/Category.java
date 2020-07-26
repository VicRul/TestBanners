package test.jarsoft.banners.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name", "reqName"})
@ToString(of = {"id", "name", "reqName"})
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30, nullable = false)
	@Setter
	private String name;

	@Column(length = 30, nullable = false)
	@Setter
	private String reqName;

	@Column
	@Setter
	private boolean deleted = false;

	public Category(String name, String reqName) {
		this.name = name;
		this.reqName = reqName;
	}
	
}