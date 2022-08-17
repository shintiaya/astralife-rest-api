package com.astralife.rest.core.enums;

public enum GeneralErrorCodeEnum {

	/**
	 * ERROR CODE CATEGORIES : 1000-1099: General Error 1100-1200: User Operation
	 * 2100-2099: Mapping 9000-9999: Other
	 */

	/**
	 * NOTE : If you want to add new error code, please give them unique code. If
	 * you want to add new error code categories, please add the error code
	 * categories note too.
	 */

	// ----------------------------------- GENERAL ERROR CODE : 1000 - 1099
	// -----------------------------------
	SUCCESS("1000", "Process successful."),
	DATABASE_NOT_EXISTS("1001", "Database is not exists, please create database first"),
	ERROR_CREATE_TMP_TABLE("1003", "Error creating temporary table"),
	ERROR_CREATE_DATABASE("1004", "Error creating database/schema"),
	ERROR_GENERATE_TABLE("1005", "Error generate table"),
	ERROR_GENERATE_VIEW_TABULAR("1006", "Error generate view tabular"),
	ERROR_DROP_VIEW_TABULAR("1007", "Error drop view tabular"),

	NO_SOURCE_MAPPING("2001", "Mapping is not found!"), 
	SOURCE_FIELD_NOT_FOUND("2002", "Source field not found!"),
	ERROR_EXECUTE_MAPPING_QUERY("2003", "There is error when execute mapping query"),
	ERROR_GET_MAPPING_PARAMETER("2004", "There is error when getting mapping parameter"),
	ERRORR_MAPPING_PROCESS("2005", "There is error when mapping the process"),

	ERROR_RENAME_FILE("3001", "Can't upload, please contact your adminstrator!"),
	ERROR_GET_UPL_EXCEL_PARAM("3002", "There is error when getting upload excel parameter"),
	ERROR_READING_EXCEL("3003", "There is error when reading excel file"),

	ERROR_QUERY_UI_SOURCE_EMPTY("10001", "Error query UI Source, result is empty!"),

	PERIOD_NOT_SET("4001", "Please set up period first!"),

	ERROR_MAPPING_REQUEST_CONFIGURATION("5001", "Error mapping request configuration!"),
	ERROR_MAPPING_FIELD_REQUEST("5002", "Error mapping field request"),
	ERROR_RECEIVE_RESPONSE("5003", "Error when receive response, Please contact your administrator!"),
	DATA_NOT_FOUND("5004", "Data not found"), 
	ERROR_CHOOSE_DATA("5005", "Please choose data first!"),
	DATA_DUPLICATE("5006", "Data duplicate"),
	
	ERROR_INSERT_QUEUE("6001", "Error inserting into queue report"),
	ERROR_CREATE_XML("6002", "Error creating XML file"), 
	ERROR_CREATE_ZIP("6003", "Error creating ZIP file"),

	ERROR_SEND_DATA("7001", "Error send data"), 
	BULK_SEND_ERROR("7002", "Error bulk process when sending data"),
	SOME_BULK_ERROR("7003", "Error some data when sending data"),

	ERROR_INSERT_CHART_SOURCE("8001", "Error when insert chart data"),
	ERROR_GET_CHART_DATA("8002", "Error when getting chart data"),
	ERROR_DROP_TABLE("8003", "Error when drop chart data"), 
	ERROR_INSERT_DATA("8004", "Error when inserting data"),
	ERROR_DELETE_DATA("8005", "Error when deleting data"), 
	ERROR_GET_DATA("8006", "Error when getting data"),

	ERROR_CUSTOM_QUERY_UI_SOURCE("9001", "Error when execute custom query UI Source data"),

	;

	private String code;
	private String defaultMessage;

	private GeneralErrorCodeEnum(String code, String defaultMessage) {
		this.code = code;
		this.defaultMessage = defaultMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

}
