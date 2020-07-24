package test.jarsoft.banners.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import test.jarsoft.banners.util.EntityIdResolver;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name", "reqName"})
@ToString(of = {"id", "name", "reqName"})
@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		scope = Category.class,
		resolver = EntityIdResolver.class,
		property = "id"
)
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private List<Banner> banners;

	public Category(String name, String reqName) {
		this.name = name;
		this.reqName = reqName;
	}
	
}