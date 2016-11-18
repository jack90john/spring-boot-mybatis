package com.jack.self.mapper.second;

import com.jack.self.model.second.TBill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TBillMapper {
	int insertSelective(@Param("tBill") TBill tBill, @Param("aesKey") String aesKey);


	List<TBill> selectBillsByDates(@Param("identityNumber") List<Integer> idNo, @Param("hospitalId") String hospitalCode,
                                   @Param("dateRegExp") String dateRegExp, @Param("billType") List<String> billType);

	List<TBill> selectBillsByDateRange(@Param("identityNumber") List<Integer> idNo, @Param("hospitalId") String hospitalCode,
                                       @Param("startDate") String startDate, @Param("endDate") String endDate,
                                       @Param("billType") List<String> billType);

	List<TBill> selectBillsByHosNo(@Param("hospitalization_no") List<String> hosNo, @Param("hospitalId") String hospitalId,
                                   @Param("startDate") String startDate, @Param("endDate") String endDate,
                                   @Param("billType") List<String> billType);

	@ResultMap("BaseResultMap")
	@Select({ "select bill_id, bill_type, patient_name, identity_number, hospital_id,",
			" hospitalization_no,hospitalization_times, visit_date, receipt_No, yard_Name,",
			" medicine_Take_Flag, order_Amount,ms_Type, invoice_No, invoice_Type, admission_Time,",
			"self_Pay, insure_Self_Pay, class_Self_Pay, other_Pay, insure_Rcpt_No, pay_Date, ",
			"visit_No,pay_Channel, cost_Category, total_Pay, discharge_Time, settle_Time,",
			"dept_Name, doctor_Name, insure_Type, insure_Pay, account_Pay, prepayments, bed_No",
			" from t_bill ",
			"where identity_number = #{identityNumber}"})
	List<TBill>selectBillsByID(@Param("identityNumber") String idNo);

}