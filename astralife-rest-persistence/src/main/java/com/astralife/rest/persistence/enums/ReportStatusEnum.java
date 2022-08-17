package com.astralife.rest.persistence.enums;

public enum ReportStatusEnum {
	CODE_00("00","Sukses"),
	CODE_500("500","Gagal"),
	CODE_999("999","Department Tidak Ditemukan!"),
	CODE_998("998","Gender Tidak Ditemukan!");
	
	private String code;
	private String description;
	
	private ReportStatusEnum(String code, String description){
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static ReportStatusEnum getByCode(String code){
		for(ReportStatusEnum en : ReportStatusEnum.values()){
			if(en.getCode().equals(code)){
				return en;
			}
		}
		return null;
	}
}
