package com.hcl.bankproduct.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;

}
