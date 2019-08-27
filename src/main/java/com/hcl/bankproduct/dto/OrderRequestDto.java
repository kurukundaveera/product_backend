package com.hcl.bankproduct.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author DeepikaSivarajan
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String customerName;
	private String mobileNumber;
	private String emailId;
	private String city;
	private Integer quantity;

}
