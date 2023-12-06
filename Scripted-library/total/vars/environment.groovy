def call() {
        //nexus
        env.SNAP_REPO = 'petclinic-snapshot'
        env.NEXUS_USER = 'admin'
        env.NEXUS_PASS = '1'
        env.RELEASE_REPO = 'petclinic-release'
        env.CENTRAL_REPO = 'petclinic-maven-central'
        env.NEXUS_IP = '159.223.51.62'
        env.NEXUS_PORT = '8081'
        env.NEXUS_GRP_REPO = 'petclinic-maven-group'
        env.NEXUS_LOGIN = 'nexuslogin'
        env.BUILD_VERSION = "${env.BUILD_ID}-${env.BUILD_TIMESTAMP}"
        // env.BUILD_VERSION = "${env.BUILD_ID}"
        env.NEXUS_LINK = "http://${NEXUS_USER}:${NEXUS_PASS}@${NEXUS_IP}:${NEXUS_PORT}/repository/petclinic-release/Multi-branch/petclinic-app/${BUILD_VERSION}/petclinic-app-${BUILD_VERSION}.jar"
        
        //Sonarqube
        env.SONARSERVER = 'sonarserver'
        env.SONARSCANNER = 'sonarscanner'
        env.PETCLINIC_REPO = 'petclinic-repo'
        env.PETCLINIC_PROJECT_KEY = 'petclinic_profile'

        //scannerHome = tool "${SONARSCANNER}"
        env.TEAM_URL = 'https://fptsoftware362.webhook.office.com/webhookb2/22a4c76f-9b43-476a-97ba-aa9efccbf616@f01e930a-b52e-42b1-b70f-a8882b5d043b/IncomingWebhook/21e5a5428b6f43f9b33b17f863fa12de/802f79b4-3a1c-4dd6-af21-353bf46dc864'
}   