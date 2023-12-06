def call(String NEXUS_IP, NEXUS_PORT, BUILD_VERSION, RELEASE_REPO, NEXUS_LOGIN) {
  
                echo 'Deploy Nexus '
                    nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: "${NEXUS_IP}:${NEXUS_PORT}",
                        groupId: 'QA',
                        version: "${BUILD_VERSION}",
                        repository: "${RELEASE_REPO}",
                        credentialsId: "${NEXUS_LOGIN}",
                        artifacts: [
                            [artifactId: 'petclinic-app' ,
                            classifier: '',
                            file: 'target/spring-petclinic-3.1.0-SNAPSHOT.jar',
                            type: 'jar']
                        ]
                    )
                
}