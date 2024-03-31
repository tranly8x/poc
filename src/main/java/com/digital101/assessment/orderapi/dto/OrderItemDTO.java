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

import com.digital101.assessment.orderapi.entities.OrderItem;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    private Integer quantity;
    private Double price;
    private String product;
    private Long order;
    public double getSubTotal;

    public OrderItemDTO(OrderItem orderItem) {
        id = orderItem.getId();
        quantity = orderItem.getQuantity();
        price = orderItem.getPrice();
        product = orderItem.getProduct().getName();
        order = orderItem.getOrder().getId();
        getSubTotal = orderItem.getSubTotal();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public double getGetSubTotal() {
		return getSubTotal;
	}

	public void setGetSubTotal(double getSubTotal) {
		this.getSubTotal = getSubTotal;
	}
}