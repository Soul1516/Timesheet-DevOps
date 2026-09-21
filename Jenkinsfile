pipeline {
    agent any

    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Soul1516/Timesheet-DevOps.git'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
    }
}