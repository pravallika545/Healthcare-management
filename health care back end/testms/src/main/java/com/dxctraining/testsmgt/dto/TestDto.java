package com.dxctraining.testsmgt.dto;


public class TestDto {

	private int id;

	private String name;

	private String centerId;

	public TestDto() {

	}

	public TestDto(int id,  String name) {
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
}