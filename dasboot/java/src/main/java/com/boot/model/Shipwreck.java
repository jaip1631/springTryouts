package com.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "shipwreck")
public class Shipwreck {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;

  String name;
	String description;
	String currentCondition;
	Integer depth;
	Double latitude;
	Double longitude;
	Integer yearDiscovered;
}
