package test.jarsoft.banners.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name", "price", "content"})
@ToString(of = {"id", "name", "price", "content", "category"})
@Entity
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 20, nullable = false)
	@Setter
	private String name;

	@Column(nullable = false)
	@Setter
	private int price;

	@Column(nullable = false)
	@Setter
	private String content;

	@Column
	@Setter
	private boolean deleted = false;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id", nullable = false)
	@JsonIdentityReference(alwaysAsId = true)
	@Setter
	private Category category;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "banner")
	private List<Request> requests;

	public Banner(String name, int price, String content, Category category) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.category = category;
	}	
}