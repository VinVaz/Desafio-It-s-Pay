package cardSystem.API.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardError {

	private Integer errCode;
	private String errMsg;
	private Date date;

}
