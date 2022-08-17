package com.astralife.rest.core.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	private static final String ZERO = "0";
	private static final String ONE = "1";
	private static final String TEN = "10";
	
	private BigDecimalUtils() {
	    throw new IllegalStateException("BigDecimalUtils");
	}
	
	public static String getWithoutComma(BigDecimal value){
		if(value != null){
			return value.toString().split("[.]")[0];
		}else return ZERO;
	}
	public static BigDecimal get10Pow(BigDecimal value){
		return new BigDecimal(TEN).pow(value.intValue());
	
	}

	public static String getWithComma(BigDecimal value) {
		if(value != null){
			return value.toString().replaceAll("[.]",",");
		}else return ZERO;
	}

	public static String getWithoutCommaPlusOne(BigDecimal value) {
		if(value != null){
			return new BigDecimal(ONE).add(value).toString().split("[.]")[0];
		}else return ZERO;
	}

}
