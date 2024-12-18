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
       /*  stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=GestionBibliotheque -Dsonar.host.url=http://votre-sonar-url -Dsonar.login=votre-token'
                }
            }
        } */
        stage('Deploy') {
            steps {
                echo 'Déploiement simulé réussi'
            }
        }
    }
}