
This application('auditDemo' App) is a spring boot REST API service for GitHub webhook events.
It is a new version of old project.

The application mission is to capture the GitHub event(I chose pull request), 
save it in mysql and screenshot of the GitHub web event itself for a "proof".

The design is flexible to other events - the branch controller is an example.

 In order to test the API with GitHub, you need a public IP/domain, or you may need to use ngrok(or other third-party App) software for temporary public tunnel between GitHub and your localhost.

>##### Few important notes you must know on the screenshot process:
> * The screenshot execute from java, therefor,  the 'auditDemo' App will catch real GitHub event only if you run the API service && executed the GitHub event in the same computer
>   * The screenshot canceled since the last 'auditDemo' App update. It does not work very well because it is needs maintenance: 
>      *  The first version WebDriverManager worked well 3 years ago. 
>     
>        Now it is throw exception because the current web driver version does not support it.
>      *  This current 'auditDemo' App version support only chrome and only Windows OS. 
>   
>           I supposed to support other OS(Linux,Mac) and their Internet Explorer.
>                                                
> 
> However, the screenshot code is still there.
> 
>Screenshot from backend was bad idea :)
>


### Try the API:

###### How to run
>You can pull this App from DockerHub:
> 
>'docker compose up' will pull this 'auditDemo' App from DockerHub + pull MySql:8.0.27 with relevant configurations
> 'swagger UI' will show you the API URLs (http://localhost:8080/swagger-ui/index.html)


###### Dummy input (In order to create the first pullRequest)
>{
"action": "opened",
"number": 11,
"pull_request": {
"userName": "string",
"created_at": "2023-11-26T13:06:00.983Z",
"url": "https://api.GitHub.com/repos/octocat/Hello-World/issues/1347",
"id": 1,
"node_id": "1296255",
"html_url": "html_url",
"number": 333,
"state": "ok",
"title": "Pull request DEMO",
"user": {
"login": "orenv3",
"id": 203,
"node_id": "string",
"avatar_url": "",
"gravatar_id": "",
"url": "user url",
"html_url": "https://api.GitHub.com/repos/octocat/Hello-World/issues/1347",
"followers_url": "",
"following_url": "",
"gists_url": "",
"starred_url": "",
"subscriptions_url": "",
"organizations_url": "",
"repos_url": "https://GitHub.com/orenv3/webhook-audit",
"events_url": "events_url",
"received_events_url": "",
"type": "powerful",
"site_admin": true
}
},
"repository": {
"id": "1296269",
"node_id": "1296255",
"name": "repo name",
"full_name": "octocat/Hello-World",
"isPrivate": "false"
},
"sender": {}
}

