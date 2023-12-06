def call(String NEXUS_LINK) {
    echo 'Ansible play book to deploy app'
    def PORT
    def BRANCH
    if(env.BRANCH_NAME == 'main')
    {
        PORT = 8080
        BRANCH = 'main'
    }
    if(env.BRANCH_NAME.startsWith('develop'))
    {
        PORT = 13456
        BRANCH = 'develop'
    }
    if(env.BRANCH_NAME.startsWith('uat'))
    {
        PORT = 13457
        BRANCH = 'uat'
    }
    ansiblePlaybook(
        credentialsId: 'ansible_credential',
        installation: 'ansible1',
        disableHostKeyChecking: 'true',
        playbook: 'ansible-playbook/playbook.yml',
        inventory: 'ansible-playbook/inventory.ini',
        extraVars: [
            app_install_dir: '/lab/application',
            app_install_file: "/lab/application/petclinic-${BRANCH}.jar",
            nexus_link: "${NEXUS_LINK}",
            PORT: PORT,
            BRANCH: "${env.BRANCH_NAME}",
        ]
    )

}