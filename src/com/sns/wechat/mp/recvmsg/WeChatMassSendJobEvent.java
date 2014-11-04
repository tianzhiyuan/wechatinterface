package com.sns.wechat.mp.recvmsg;

import java.io.Serializable;

import com.sns.wechat.mp.enumpackage.WeChatEventType;

/**
 * 微信群发消息结果推送事件
 * @author Tian Zhiyuan
 * @date 2014年10月10日
 * @version 0.1
 */
public class WeChatMassSendJobEvent extends WeChatEventMsg implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getEvent() {
		// TODO Auto-generated method stub
		return WeChatEventType.EVENT_MASSSENDJOBFINISH.toString();
	}

	/**
	 * 群发的消息ID
	 */
	private long msgId;
	/**
	 * 群发的结果，为“send success”或“send fail”或“err(num)”。
	 * send success时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败
	 */
	private String status;
	/**
	 * group_id下粉丝数；或者openid_list中的粉丝数
	 */
	private int totalCount;
	/**
	 * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
	 */
	private int filterCount;
	/**
	 * 发送成功的粉丝数
	 */
	private int sendCount;
	/**
	 * 发送失败的粉丝数
	 */
	private int errorCount;

	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getFilterCount() {
		return filterCount;
	}
	public void setFilterCount(int filterCount) {
		this.filterCount = filterCount;
	}
	public int getSendCount() {
		return sendCount;
	}
	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	/**
	 * 获取错误描述
	 * @return
	 */
	public String getErrDescription(){
		if(this.status == null || this.status.isEmpty()){
			return this.status;
		}
		if(!this.status.startsWith("err")){
			return this.status;
		}
		String code = this.status.replace("err(", "").replace(')', '\0');
		return code;
	}
}
