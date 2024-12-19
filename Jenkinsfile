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
        stage('send email'){
            steps {
                mail bcc: '', body: '''Bonjour,
                 nouvelle notification concernant le projet de gestion de bibliotheque ''', cc: '', from: '', replyTo: '', subject: 'Notifications du projet de  Gestion des biblio', to: 'belaid.tarikk@gmail.com'
            }
    }
}
