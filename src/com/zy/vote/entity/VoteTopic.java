package com.zy.vote.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import com.zy.common.entity.BaseEntity;

/**
 * 投票主题
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "vote_topic")
public class VoteTopic extends BaseEntity{

	private static final long serialVersionUID = -99057880624174607L;
	
	public static final String SCHEDULE_DEFAULT = "0";
	public static final String SCHEDULE_CURRENT = "1";//当前期
	public static final String SCHEDULE_NEXT = "2";	// 下期

	
	private List<VoteTopicOption> options;			//主题投票选项
	private List<VoteTopicPost> posts;				//投票评论
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;							//开始日期
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;							//结束日期
	private String titleContent;					//题目内容
	private Boolean isComment;						//是否开启评论功能（1-开启，0-关闭）
	private String displayPosition;					//显示位置（0-用户中心，1-网页，2-用户中心+网页）
	private String displayType;						//显示模式(0-百分比，1-实数)
	private String schedule;						//排期（0-初始值，1-当前期，2-下期）
	private Integer voteCount = 0;					//总投票数
	private Integer postCount;						//总跟帖数量
	private String imageUrl; 						//主题图，保存相对路径
	
	
	
	//用于页面显示或查询
	private Integer imageHeight;					//主题图片高
	private Integer imageWidth;						//主题图片宽
	private String[] optionContent;					//选项内容
	private VoteTopicPost mostPraisePost1; 			//最多人点赞帖子
	private VoteTopicPost mostPraisePost2;			//最多人点赞帖子
	private Boolean isVoteTime;						//根据startDate，endDate判断是否可以投票
	
	@javax.persistence.Transient
	public Integer getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}
	@javax.persistence.Transient
	public Integer getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}
	@javax.persistence.Transient
	public String[] getOptionContent() {
		return optionContent;
	}
	public void setOptionContent(String[] optionContent) {
		this.optionContent = optionContent;
	}
	@javax.persistence.Transient
	public VoteTopicPost getMostPraisePost1() {
		return mostPraisePost1;
	}
	public void setMostPraisePost1(VoteTopicPost mostPraisePost1) {
		this.mostPraisePost1 = mostPraisePost1;
	}
	@javax.persistence.Transient
	public VoteTopicPost getMostPraisePost2() {
		return mostPraisePost2;
	}
	public void setMostPraisePost2(VoteTopicPost mostPraisePost2) {
		this.mostPraisePost2 = mostPraisePost2;
	}
	@javax.persistence.Transient
	public Boolean getIsVoteTime() {
		return isVoteTime;
	}
	public void setIsVoteTime(Boolean isVoteTime) {
		this.isVoteTime = isVoteTime;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voteTopic")
	@OrderBy("id")
	public List<VoteTopicOption> getOptions() {
		return options;
	}
	public void setOptions(List<VoteTopicOption> options) {
		this.options = options;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "voteTopic")
	@OrderBy("createDate desc")
	public List<VoteTopicPost> getPosts() {
		return posts;
	}
	public void setPosts(List<VoteTopicPost> posts) {
		this.posts = posts;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(length=128)
	public String getTitleContent() {
		return titleContent;
	}
	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}
	@Column(length=2)
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	@Column(length=2)
	public String getDisplayPosition() {
		return displayPosition;
	}
	public Boolean getIsComment() {
		return isComment;
	}
	public void setIsComment(Boolean isComment) {
		this.isComment = isComment;
	}
	public void setDisplayPosition(String displayPosition) {
		this.displayPosition = displayPosition;
	}
	@Column(length=2)
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	@Column(length=64)
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}


	
	
}
