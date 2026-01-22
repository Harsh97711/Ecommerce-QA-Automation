pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Run Automation Tests') {
            steps {
                dir('Automation') {
                    bat 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml'
                }
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'Automation/target',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Automation Report',
                keepAll: true,
                alwaysLinkToLastBuild: true
            ])
        }
    }
}
