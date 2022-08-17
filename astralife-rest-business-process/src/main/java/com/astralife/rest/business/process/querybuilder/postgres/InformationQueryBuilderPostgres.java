package com.astralife.rest.business.process.querybuilder.postgres;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.astralife.rest.business.process.querybuilder.InformationQueryBuilder;
import com.astralife.rest.core.constants.DatabaseProfile;

@Component
@Profile(DatabaseProfile.POSTGRE)
public class InformationQueryBuilderPostgres implements InformationQueryBuilder{

	@Override
	public String getLastIdEmployee() {
		StringBuilder result = new StringBuilder();
		result.append(" select max(emp_no) from employee; ");
		return result.toString();
	}

}
