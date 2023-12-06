def call() {
     //declarative
    //  steps{
    //     timeout(time: 10, unit: 'MINUTES') {
    //     waitForQualityGate abortPipeline: true
    //     }
    // }


    //scripted  
    timeout(time:  3, unit: 'MINUTES') {
        script {
            def qualityGate = waitForQualityGate abortPipeline: true

            if (qualityGate.status != 'OK') {
                    error "Quality gate failed"
                }
        }
    }
}