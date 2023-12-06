// Gmail notification, turn off to reduce junk
    post{
        always {
            echo 'One way or another, I have finished'
        
        }
        success {
            mail to: 'danielnhatng@gmail.com',
            subject: "Success Pipeline: ${currentBuild.fullDisplayName}",
            body: "Pipeline ${env.BUILD_URL} has run succesfully"
        }
        
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            // mail to: 'danielnhatng@gmail.com',
            // subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
            // body: "Something is wrong with ${env.BUILD_URL}"

            //def console_output = "${env.BUILD_URL}/conso
            mail bcc: '', body: "Details: ${env.JOB_NAME} Build Number: ${env.BUILD_NUMBER} Build: ${env.BUILD_URL} \
            Console Output: ${env.BUILD_URL}/console", cc: '', from: 'noreply+jaas@sap.com', replyTo: '', subject: 'Pipline fail', to: 'danielnhatng@gmail.com'
        }

        def sendFailureEmail(stageName) {
            emailext (
                subject: "Pipeline Failed: ${env.JOB_NAME}",
                body: "The Jenkins pipeline ${env.JOB_NAME} has failed at stage: ${stageName}. Please check the console output for more details.",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                attachLog: true
            )
        }
    }