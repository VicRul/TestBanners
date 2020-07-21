package test.jarsoft.banners.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryDto {

	private int id;
	private String name;
	private String reqName;
	private boolean deleted;
	private List<BannerDto> bannersDto;
}