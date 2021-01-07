package com.example.demo.service;

import com.alipay.api.AlipayApiException;
import com.example.demo.bean.aliPay.AlipayBean;

/*支付服务*/
public interface PayService {
    /*支付宝*/
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}