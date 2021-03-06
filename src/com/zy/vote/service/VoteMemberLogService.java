package com.zy.vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.vote.dao.VoteMemberLogDao;
import com.zy.vote.entity.VoteMemberLog;

@Service
public class VoteMemberLogService extends CommonService<VoteMemberLog,String>{

	@Autowired
	private VoteMemberLogDao voteMemberLogDao;
	
	@Autowired
	public void setVoteMemberLogDao(VoteMemberLogDao voteMemberLogDao) {
		super.setCommonDao(voteMemberLogDao);
	}
	
	public PageModel<VoteMemberLog> queryForPage(VoteMemberLog queryDto,
			PageModel<VoteMemberLog> pageModel){
		
		return voteMemberLogDao.queryForPage(queryDto, pageModel);
	}
	
	public int findMemberTopicLog(String memberId, String topicId){
		return voteMemberLogDao.findMemberTopicLog(memberId, topicId);
	}
	
	public int findTopicLogByIp(String topicId, String ipAddress){
		return voteMemberLogDao.findTopicLogByIp(topicId, ipAddress);
	}
	
}
