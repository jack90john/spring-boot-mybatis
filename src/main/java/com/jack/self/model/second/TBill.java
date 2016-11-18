package com.jack.self.model.second;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TBill {
    private Long billId;

    private Long transIndex;

    private String queryInfoId;

    private Short billType;

    private String patientName;

    private byte[] encryptName;

    private String identityNumber;

    private byte[] encryptId;

    private Integer hospitalId;

    private String hospitalizationNo;

    private Integer hospitalizationTimes;

    private Integer admissionTimes;

    private Date visitDate;

    private String receiptNo;

    private String yardName;

    private Boolean medicineTakeFlag;

    private BigDecimal orderAmount;

    private Short msType;

    private String invoiceNo;

    private String invoiceType;

    private Date admissionTime;

    private String insurType;

    private BigDecimal insurPay;

    private BigDecimal accountPay;

    private BigDecimal selfPay;

    private BigDecimal insurSelfPay;

    private BigDecimal classSelfPay;

    private BigDecimal otherPay;

    private String insurRcptNo;

    private Date payDate;

    private String visitNo;

    private Short payChannel;

    private String costCategory;

    private BigDecimal totaPay;

    private Date dischargeTime;

    private Date settleTime;

    private Date settlementTime;

    private String deptName;

    private String doctorName;

    private String treatDoctor;

    private BigDecimal prepayments;

    private String bedNo;

    private Integer identityNumberPart;
}