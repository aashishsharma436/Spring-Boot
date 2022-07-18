package com.springbootTrendNext.Assessment1.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductDetailsEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;
}
