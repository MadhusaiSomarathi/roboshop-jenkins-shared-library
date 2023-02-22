def codeCheckout() {
    stage('Code Checkout') {
        echo 'code checkout'
    }
}

def codeQuality() {
    stage('Code Quality') {
        echo 'code Quality'
    }
}

def codeChecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {
        echo 'codeChecks'
    }
}

def artifacts() {
    if (env.TAG_NAME ==~ ".*") {

        stage('Download dependencies') {
            echo 'Download dependencies'
        }
        stage('Prepare Artifacts') {
            echo 'Prepare Artifacts'
        }
        stage('Publish Artifacts') {
            echo 'Publish Artifacts'
        }
    }

}
