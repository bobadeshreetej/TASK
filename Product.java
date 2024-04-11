package com.machine.test.crud.entity;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Data
@Component
public class Product implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2235989396966213347L;

	@Id
    @Column(name = "prod_id")
    private int prodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catg_id")
    private Category category;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_description")
    private String prodDescription;

    
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
    
    

}
