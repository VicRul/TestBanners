package test.jarsoft.banners.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BannerDto {

	private long id;
	private String name;
	private int price;
	private CategoryDto categoryDto;
	private String content;
	private List<RequestDto> requestsDto;
	private boolean deleted;
}