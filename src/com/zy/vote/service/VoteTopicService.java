package com.zy.vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.vote.dao.VoteTopicDao;
import com.zy.vote.dto.VoteTopicDto;
import com.zy.vote.entity.VoteTopic;
import com.zy.vote.entity.VoteTopicOption;

@Service
public class VoteTopicService extends CommonService<VoteTopic,String>{

	@Autowired
	private VoteTopicDao voteTopicDao;
	@Autowired
	private VoteTopicOptionService  voteTopicOptionService;
	
	@Autowired
	public void setVoteTopicDao(VoteTopicDao voteTopicDao) {
		super.setCommonDao(voteTopicDao);
	}
	
	public PageModel<VoteTopic> queryPage(VoteTopicDto queryDto){
		return voteTopicDao.queryForPage(queryDto);
	}
	
	/**
	 * 新增投票主题、投票选项
	 * @param dto
	 */
	public void saveTopicAndOptions(VoteTopic dto){
		if(dto.getOptionContent()==null || dto.getOptionContent().length<1)
			throw new RuntimeException("选项内容空");
		VoteTopic entity = voteTopicDao.save(dto);
		for(String optionContent:dto.getOptionContent()){
			VoteTopicOption option = new VoteTopicOption();
			option.setVoteTopic(entity);
			option.setOptionContent(optionContent);
			voteTopicOptionService.save(option);
		}
	}
	
	/**
	 * 修改投票主题、投票选项
	 * @param dto
	 */
	public void updateTopicAndOptions(VoteTopic dto){
		if(dto.getOptionContent()==null || dto.getOptionContent().length<1)
			throw new RuntimeException("选项内容空");
		voteTopicDao.save(dto);
		List<VoteTopicOption> options = voteTopicOptionService.getOptionByVoteTopic(dto.getId());
		for(int i=0; i<options.size(); i++){
			VoteTopicOption option = options.get(i);
			option.setOptionContent(dto.getOptionContent()[i]);
			voteTopicOptionService.update(option);
		}
	}
}
