package com.machine.test.crud.entity;
import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Component
public class Category implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6239154102008698229L;

	@Id
    @Column(name = "catg_id")
    private Integer catgId;

    @Column(name = "catg_name")
    private String catgName;

    @Column(name = "catg_description")
    private String catgDescription;
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

	public Integer getCatgId() {
		return catgId;
	}

	public void setCatgId(Integer catgId) {
		this.catgId = catgId;
	}

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getCatgDescription() {
		return catgDescription;
	}

	public void setCatgDescription(String catgDescription) {
		this.catgDescription = catgDescription;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

    
}
