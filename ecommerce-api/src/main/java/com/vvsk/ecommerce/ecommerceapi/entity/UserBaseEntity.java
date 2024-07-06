package com.vvsk.ecommerce.ecommerceapi.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseEntity extends AuditableEntity {
	
	@Column(name="NAME", length = 100, unique = true,insertable = true, updatable = false)
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
