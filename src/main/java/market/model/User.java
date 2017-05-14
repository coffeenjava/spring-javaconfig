package market.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lcrapper on 2017. 4. 25..
 */
@Getter
@Setter
@Builder
public class User {
	private String userId;
	private String userNm;
	private String phone;
	private String comment;
}
