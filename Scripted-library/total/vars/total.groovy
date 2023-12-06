def call() {
    node {

        // try {

        //Set up   
        stage('Checkout scm') {
            checkoutSCM()
        }
        stage('Tool configuration'){
            toolConfig()
        }
        stage('Set up environment'){
            environment()
        }
        


        // Build
        stage('Compile') {
        
            compile() 
        
        }
        stage('Unit test') {
            
            unitTest()
            
        }


    //scanCode
    stage('Scan SonarQube') {
        sonarScan(env.SONARSERVER)
    }
    stage('Quality Gate') {
        //  qualityGate()
    }
    stage('GetTag'){
        getTag(env.BRANCH_NAME)
    }
    stage('Deploy Nexus') {
        deployNexus(env.NEXUS_IP, env.NEXUS_PORT, env.BUILD_VERSION, env.RELEASE_REPO, env.NEXUS_LOGIN)
    }
    stage('Deployment') {
        deployment(env.NEXUS_LINK)     
    }
    stage('Check health') {
        checkHealth()   
    }
    // stage('Team Notification') {
    //     teamNoti(env.TEAM_URL)
    // }
    
// }   catch (Exception e) { 
//         env.ERROR_MESSAGE = e.getMessage()
//         throw e
// }   

//end
    stage('Team Notification') {
        teamNoti(env.TEAM_URL)
    }
    }

}
