package com.vvsk.ecommerce.ecommerceapi.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AuditableEntity {
	
	@CreatedBy
	@Column(name="CREATED_BY",insertable = true, updatable = false)
	private String createdBy;
	
	@CreatedDate
	@Column(name="CREATED_DATE",insertable = true, updatable = false)
	private LocalDateTime createdDate;
	
	@LastModifiedBy
	@Column(name="LAST_MODIFIED_BY", insertable = true, updatable = true)
	private String lastUpdatedBy;
	
	@LastModifiedDate
	@Column(name="LAST_MODIFIED_DATE", insertable = true, updatable = true)
	private LocalDateTime updatedDate;

}
