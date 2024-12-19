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
                           sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=GestionBiblio -Dsonar.projectName='GestionBiblio'"

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
