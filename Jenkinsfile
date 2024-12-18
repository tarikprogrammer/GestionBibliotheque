pipeline {
   agent any
   tools {
          maven 'Maven'
    }
    stages {
        /* stage('Checkout') {
            steps {
                git 'https://github.com/votre-depot/GestionBibliotheque.git'
            }
        } */
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Quality Analysis') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Déploiement simulé réussi'
            }
        }
    }
    /* post {
        success {
            emailext to: 'belaid.tarikk@gmail.com',
                subject: 'Build Success',
                body: 'Le build a été complété avec succès.'
        }
        failure {
            emailext to: 'belaid.tarikk@gmail.com',
                subject: 'Build Failed',
                body: 'Le build a échoué.'
        }
    } */
}
