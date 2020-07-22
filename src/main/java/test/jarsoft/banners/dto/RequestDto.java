package test.jarsoft.banners.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RequestDto {

	private long id;
	private String userAgent;
	private String ipAddress;
	private LocalDateTime date;
	private BannerDto bannerDto;
}