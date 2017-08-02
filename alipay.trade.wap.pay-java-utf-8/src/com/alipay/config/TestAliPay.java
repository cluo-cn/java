package com.alipay.config;

import java.net.URLDecoder;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;

public class TestAliPay {
	public static void main(String[] args) {
		/**********************/

	}

	public static String getData() {
		AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
				AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
				AlipayConfig.SIGNTYPE);

		AlipayTradeAppPayRequest alipay_request = new AlipayTradeAppPayRequest();
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setOutTradeNo("" + System.currentTimeMillis());
		model.setSubject("商品测试");
		model.setTotalAmount("0.01");
		model.setBody("商品测试0.01");
		model.setTimeoutExpress("30m");
		model.setProductCode("QUICK_WAP_PAY");
		alipay_request.setBizModel(model);

		alipay_request.setNotifyUrl(AlipayConfig.notify_url);
		String body = "";
		try {
			body = client.sdkExecute(alipay_request).getBody();
			String decode = URLDecoder.decode(body, "UTF-8");
			System.out.println(body);
			System.out.println(decode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}
