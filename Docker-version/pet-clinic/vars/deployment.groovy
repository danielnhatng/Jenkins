def call(String NEXUS_LINK) {
    
        echo 'Ansible play book to deploy app'
        ansiblePlaybook(
            credentialsId: 'ansible_credential',
            installation: 'ansible1',
            disableHostKeyChecking: 'true',
            playbook: 'ansible-playbook/playbook.yml',
            inventory: 'ansible-playbook/inventory.ini',
            extraVars: [
                app_install_dir: '/lab/application',
                app_install_file: '/lab/application/petclinic.jar',
                nexus_link: "${NEXUS_LINK}",
            ]
        )
    
}