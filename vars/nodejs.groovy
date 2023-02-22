def call() {
//    env.APPTYPE = "nodejs"
    node {
        try {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        } catch (Exception e) {
            mail bcc: '', body: "Build Failed ${RUN_DISPLAY_URL}", cc: '', from: 'msamrat789@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'msamrat789@gmail.com'
        }

    }

}