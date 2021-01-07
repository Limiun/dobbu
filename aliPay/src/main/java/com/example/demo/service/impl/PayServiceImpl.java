package com.example.demo.service.impl;

import com.alipay.api.AlipayApiException;
import com.example.demo.bean.aliPay.AlipayBean;
import com.example.demo.config.aliPay.AlipayUtil;
import com.example.demo.service.PayService;
import org.springframework.stereotype.Service;

/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}