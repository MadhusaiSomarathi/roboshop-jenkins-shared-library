def codeCheckout() {
    stage('Code Checkout') {
        sh 'find . | sed 1d |xargs rm -rf'
        git branch: 'main', url: "https://github.com/raghudevopsb67/${COMPONENT}.git"
    }
}

def codeQuality() {
    stage('Code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
        sonar-scanner -Dsonar.host.url=http://172.31.28.6:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true
        echo OK
      '''
        }
    }
}

def codeChecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {

        stage('Style & Lint Checks') {
            echo 'Style Checks'
        }

        stage('Unit Tests') {
            echo 'Unit Tests'
        }

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
