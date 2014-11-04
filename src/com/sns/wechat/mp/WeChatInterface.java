package com.sns.wechat.mp;
/**
 * 微信接口
 * @author Tian Zhiyuan
 * @date 2014.10.9
 * @version 0.1
 */
public interface WeChatInterface {
	/**
	 * 向微信公众平台发起请求
	 * @param request 请求DTO实例
	 * @return 请求结果.为空表示请求失败。errcode != 0表示有错误 
	 */
	public<TResponse extends ResponseBase> TResponse execute(
				RequestBase<TResponse> request);
	/**
	 * 验证是否来自微信的请求
	 * @param nonce 随机数
	 * @param timestamp 时间戳
	 * @param token token
	 * @param signature 待验证的签名
	 * @return 是否是来自微信的请求
	 */
	public boolean VerifySignature(String nonce, String timestamp, String token, String signature);
}
