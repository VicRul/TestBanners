package test.jarsoft.banners.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Banner> banners = new ArrayList<>();

	public Category(String name, String reqName) {
		this.name = name;
		this.reqName = reqName;
	}
	
}