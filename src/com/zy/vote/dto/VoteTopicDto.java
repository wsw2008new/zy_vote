package com.zy.vote.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zy.common.entity.PageModel;
import com.zy.vote.entity.VoteTopic;

public class VoteTopicDto extends PageModel<VoteTopic>{

	private static final long serialVersionUID = 5134167590120542266L;
	
	public static final String RESULT_CODE_VOTE_ERROR = "401";//用户对投票重复投票
	public static final String RESULT_CODE_PRAISE_ERROR = "402";//用户对帖子重复点赞
	public static final String RESULT_CODE_REPORT_ERROR = "403";//用户对帖子重复举报
	public static final String RESULT_CODE_RANDOMCODE_ERROR = "404";//验证码错误
	public static final String RESULT_CODE_LOGIN_ERROR = "405";//用户未登录错误
	public static final String RESULT_CODE_VOTE_PERMIT_ERROR = "406";//投票未开启评论错误
	
	private String id;//主键
	private String optionId;//主题投票选项
	private Date startDate;//开始日期
	private String titleContent;//题目内容
	private Boolean isComment;//是否开启评论功能（1-开启，0-关闭）
	private String displayPosition;//显示位置（0-用户中心，1-网页，2-用户中心+网页）
	private String displayType;//显示模式(0-百分比，1-实数)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDateBegin;//查询时间（开始）
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDateEnd;//查询时间（结束）
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date toDateBegin;//查询时间（开始）
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date toDateEnd;//查询时间（结束）
	
	private String schedule;
	
	private String[] ids;
	private Integer deleteFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getTitleContent() {
		return titleContent;
	}
	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}
	public String getDisplayPosition() {
		return displayPosition;
	}
	public void setDisplayPosition(String displayPosition) {
		this.displayPosition = displayPosition;
	}
	public Date getStartDateBegin() {
		return startDateBegin;
	}
	public void setStartDateBegin(Date startDateBegin) {
		this.startDateBegin = startDateBegin;
	}
	public Date getStartDateEnd() {
		return startDateEnd;
	}
	public void setStartDateEnd(Date startDateEnd) {
		this.startDateEnd = startDateEnd;
	}
	public Boolean getIsComment() {
		return isComment;
	}
	public void setIsComment(Boolean isComment) {
		this.isComment = isComment;
	}
	public Date getToDateBegin() {
		return toDateBegin;
	}
	public void setToDateBegin(Date toDateBegin) {
		this.toDateBegin = toDateBegin;
	}
	public Date getToDateEnd() {
		return toDateEnd;
	}
	public void setToDateEnd(Date toDateEnd) {
		this.toDateEnd = toDateEnd;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
	
}
