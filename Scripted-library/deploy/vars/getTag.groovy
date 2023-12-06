def call(String BRANCH_NAME) {
    
    withCredentials([gitUsernamePassword(credentialsId: 'gitlablogin')]){
        def gitHash = sh(returnStdout: true, script: 'git rev-parse HEAD | cut -c 1-4').trim()     
        def TAG_NAME
        
        // Create a new tag at the current commit
        if(env.BRANCH_NAME =='main')
        {
            TAG_NAME = "${env.BUILD_TIMESTAMP}-release"
            sh "git tag ${TAG_NAME}"
            sh "git push origin ${TAG_NAME}"
        }
        // Push the newly created tag to the remote repository
        if(env.BRANCH_NAME =='uat')
        {
            TAG_NAME = "${env.BUILD_TIMESTAMP}-uat-${gitHash}"
            sh "git tag '${TAG_NAME}'"
            sh "git push origin ${TAG_NAME}"
        }
        return TAG_NAME
    }
}
    