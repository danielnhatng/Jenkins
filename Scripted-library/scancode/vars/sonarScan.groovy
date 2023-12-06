def call(String SONARSERVER) {
                echo 'Scan SonarQube '
                withSonarQubeEnv("${SONARSERVER}") {
                    // sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=petclinic_profile \
                    //     -Dsonar.projectName=petclinic-repo \
                    //     -Dsonar.projectVersion=1.0 \
                    //     -Dsonar.sources=src/ \
                    //     -Dsonar.java.binaries=target/ \
                    //     -Dsonar.junit.reportsPath=target/surefire-reports/ \
                    //     -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                    //     -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml'''


                    mavenScan("sonar:sonar -Dcheckstyle.skip")
                }
            
}