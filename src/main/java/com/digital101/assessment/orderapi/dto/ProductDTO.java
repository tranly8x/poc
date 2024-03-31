/* 
* Use and distribution of this code is subject to applicable 
* licenses and the permission of the code owner. This notice 
* does not indicate the actual or intended publication of 
* this source code.
* 
* Portions developed for 101Digital by Software Development team
* LLC and are the property of 101Digital Inc.
* 
* ===== RP Modification ===========================================
* Req/Bug/Task ID#         MMddYYY    Author(s)    Description
* POC                      03282024   Ly Tran      Microservices Engineer Assessment Project v1.0
* ==================================================================
*/
package com.digital101.assessment.orderapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import com.digital101.assessment.orderapi.entities.Product;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    @NotNull(message = "Name can't be null or empty")
    @Size(min = 3, max = 25)
    private String name;
    @NotNull(message = "Price can't be null or empty")
    @Max(value = 999, message = "Price can't exceed 999.00")
    @Min(value = 5, message = "Price can't be lower than 5")
    private Double price;

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}