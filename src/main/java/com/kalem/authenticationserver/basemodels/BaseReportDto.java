package com.kalem.authenticationserver.basemodels;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Mohammad Nobakht on 23.01.2019
 */
@Getter
@Setter
@Data
public class BaseReportDto extends BaseDto {

    Integer companyNumber;

    String companyDescription;

    String workingPeriodNumber;

    String workingPeriodDescription;

}
