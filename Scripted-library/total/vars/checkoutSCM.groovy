def call(String BRNACH_NAME) {
    checkout([
        $class: 'GitSCM',
        branches: scm.branches,
        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
        extensions: scm.extensions,
        userRemoteConfigs: [[credentialsId: 'gitlablogin', url: 'http://143.198.193.73/s68/pet-clinic.git']]])
}