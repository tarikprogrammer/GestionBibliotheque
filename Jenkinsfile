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
       stage('SonarQube Analysis') {
                   steps {
                       withSonarQubeEnv('sonarQube') {
                           sh 'mvn sonar:sonar -Dsonar.projectKey=sqp_410a23b5d566db858cc83d23ad97996d5a932d74 -Dsonar.host.url=http://localhost:9000'
                       }
                   }
               }
        stage('Deploy') {
            steps {
                echo 'Déploiement simulé réussi'
            }
        }
    }
}