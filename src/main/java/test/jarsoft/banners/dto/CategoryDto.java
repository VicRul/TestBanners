package test.jarsoft.banners.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import test.jarsoft.banners.domain.Category;
import test.jarsoft.banners.util.EntityIdResolver;

@Data
@AllArgsConstructor
@Builder
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		scope = Category.class,
		resolver = EntityIdResolver.class,
		property = "id"
)
public class CategoryDto {

	private int id;
	private String name;
	private String reqName;
	private boolean deleted;
}