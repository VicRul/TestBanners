package test.jarsoft.banners.dto;

import java.util.Date;

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
	private Date date;
	private BannerDto bannerDto;
}