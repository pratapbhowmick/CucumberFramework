pipeline {
    agent any  // Runs on any available Jenkins agent

    tools {
        maven 'MAVEN_HOME'  // Use your configured Maven version in Jenkins
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/pratapbhowmick/CucumberFramework.git', branch: 'master'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Publish Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE', fileIncludePattern: '**/target/cucumber-reports/*.json', jsonReportDirectory: 'target/cucumber-reports'
            }
        }
    }
}