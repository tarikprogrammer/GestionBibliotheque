pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tarikprogrammer/GestionBibliotheque.git'
            }
        }
        stage('clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('compile') {
                    steps {
                        sh 'mvn compile'
                    }
                }
    
    }
}
