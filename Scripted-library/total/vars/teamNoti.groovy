def call(String TEAM_URL) {
    // Declarative
    // options {
    //     office365ConnectorWebhooks([
    //         [name: "Office 365", url: "${TEAM_URL}", notifyBackToNormal: true, notifyFailure: true, notifyRepeatedFailure: true, notifySuccess: true, notifyAborted: true]
    //     ])
    // }

    // Scripted
    properties([
        office365ConnectorWebhooks([
            [name: "Office 365", url: "${TEAM_URL}", notifyBackToNormal: true, 
            notifyFailure: true, notifyRepeatedFailure: true, notifySuccess: true, notifyAborted: true, ]
        ])
    ])
    // use finally for try catch
}