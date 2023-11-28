package com.auditDemo.utils.printscreen;

import com.auditDemo.entities.tables.Picture;
import com.auditDemo.entities.dto.PullRequestWrapper;

public class PullRequestScreenshot extends PrintScreen{
	

	public PullRequestScreenshot(PullRequestWrapper pullReqWrp) {
		this.setName(this.getClass().getSimpleName());
		setNameFormat(pullReqWrp.getPull_request().getCreated_at()
				,"ddMMyy",pullReqWrp.getPull_request().getUserName()
				, pullReqWrp.getAction()
				,pullReqWrp.getPull_request().getPullRequest_id()+"");
		this.picture = new Picture(this.strBuilder.toString());
		
		this.BASE_DIRECTORY_PATH="C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\myApp\\pullRequest_screenshots";
//		createFilePath(BASE_DIRECTORY_PATH);
		this.url = pullReqWrp.getPull_request().getHtml_url();
	}
	
	
	
}
