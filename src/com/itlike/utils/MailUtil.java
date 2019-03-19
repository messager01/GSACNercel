package com.itlike.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	// 邮箱服务器用户名和密码
	private static final String user = "no-reply@nercel.com";
	private static final String password = "QingBUYAOhuifuwo.3821";

	// 发送者邮箱地址
	private static final String fromAddress = "no-reply@nercel.com";

	/**
	 * 发送邮件
	 * 
	 * @author zhouyu
	 * @param toAddress
	 *            目标邮箱地址
	 * @param subject
	 *            邮件主题(标题)
	 * @param content
	 *            邮件内容
	 */
	public static void sendMail(String toAddress, String subject, String content) {

		// String toAddress = "478015950@qq.com";
		// String subject = "邮件测试主题";
		// String content = "这是一个测试邮件<b>哈哈</b>";
		// 配置参数
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");// 需要验证
		props.setProperty("mail.transport.protocol", "smtp");// 发送邮件协议 
		props.setProperty("mail.host", "smtp.exmail.qq.com");
		// 方法一：使用transport对象发送邮件
		// 通过参数生成会话
		Session session = Session.getInstance(props);
		// 启用调试模式
		session.setDebug(false);
		// 创建一封邮件，并设置信息
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromAddress));
			message.setSubject(subject);
			message.setText(content);
			// 创建传输
			Transport transport = session.getTransport();
			// 连接smtp服务器
			transport.connect(user, password);
			// 发送
			transport.sendMessage(message,
					new InternetAddress[] { new InternetAddress(toAddress) });
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * 
	 * @author jack
	 * @param toAddress
	 *            目标邮箱地址
	 * @param subject
	 *            邮件主题(标题)
	 * @param content
	 *            邮件内容(支持超链接等富文本)
	 */
	public static void sendRichContentMail(String toAddress, String subject,
			String content) {

		// 配置参数
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");// 发送服务器需要身份验证
		props.setProperty("mail.transport.protocol", "smtp"); // 发送邮件协议名称
		props.setProperty("mail.host", "smtp.exmail.qq.com"); // 设置邮件服务器主机名
		// 方法一：使用transport对象发送邮件
		// 通过参数生成会话
		Session session = Session.getInstance(props);
		// 启用调试模式
		session.setDebug(false);
		// 创建一封邮件，并设置信息
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromAddress));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=gb2312");
			// 创建传输
			Transport transport = session.getTransport();
			// 连接smtp服务器
			transport.connect(user, password);
			// 发送
			transport.sendMessage(message,
					new InternetAddress[] { new InternetAddress(toAddress) });
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成活动专家邀请邮件
	 * 
	 * @author zhouyu
	 * @param ucName
	 *            被邀请专家姓名
	 * @param sponsor
	 *            活动举办单位
	 * @param activityName
	 *            活动名称
	 * @param beginDate
	 *            活动开始时间
	 * @param endDate
	 *            活动结束时间
	 * @param evalBeginDate
	 *            评审开始时间
	 * @param evalEndDate
	 *            评审结束时间
	 * @param username
	 *            专家用户名
	 * @param password
	 *            专家密码
	 * @param resCount
	 *            被分配的任务数
	 * @param sponsorUcName
	 *            举办单位管理员姓名
	 * @return 邮件富文本
	 */
	public static String generateInvitation(int tactivityId, int userId,
			String ucName, String sponsor, String activityName,
			String beginDate, String endDate, String evalBeginDate,
			String evalEndDate, String username, String password, int resCount,
			String sponsorUcName,String cyberRoot) {

		StringBuffer sbuff = new StringBuffer();
		sbuff.append("尊敬的：" + ucName + "专家，您好!<br>");
		sbuff.append(sponsorUcName + " 举办的活动“" + activityName + "” 诚邀您评审<br>");
		sbuff.append("活动时间：" + beginDate + "~" + endDate + "<br>");
		sbuff.append("应邀截止时间：" + evalBeginDate +"<br>");
		sbuff.append("评审截止时间：" + evalEndDate + "<br>");
		sbuff.append("您的专家账号/默认密码：" + username + "/123456【如修改过密码，请用修改后的密码登录；如无法登录，请联系管理员为您重置密码。】<br>");
		sbuff.append("待审核作品数：" + resCount + "<br>");
		sbuff.append("点击链接查看评审邀请  <a style='color:green' href='http://localhost:8080/#/invite/"
				+ tactivityId + "?userId=" + userId + "'>任务详情</a><br>");
		sbuff.append("或复制地址："+cyberRoot+"dist/index.html#/invite/" + tactivityId
				+ "?userId=" + userId + "<br>");

		return sbuff.toString();
	}

	/*	public static void main(String[] args) {
			String toAddress = "ccnumiaowu@sina.com";
			String subject = "云平台密码重置";
			String content = "点击链接重置密码  <a style='color:green' href='http://localhost:8080/cyberhouse/main.jsp?id=12873kasdhaksj'>重置密码</a> <br> 注意保护好您的邮件信息，防止泄露！";
			// 配置参数
			sendRichContentMail(toAddress,subject,content);
		}*/

	public static void main(String[] args) {
		String toAddress = "478015950@qq.com";
		String subject = "评审邀请";
		String content = "点击链接查看评审邀请  <a style='color:green' href='http://ps.test.nercel.cn/'>任务详情</a>";
		// 配置参数
		sendRichContentMail(toAddress, subject, content);
	}

	/**
	 * 生成指定位数随机验证码
	 * 
	 * @author zhouyu
	 * @param length
	 *            长度
	 * @return 随机码
	 */
	public static String generateVerCode(int length) {

		String verCode = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			verCode += random.nextInt(10);
		}
		return verCode;
	}

}
