pipeline {
    agent any

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "🔧 Build en cours..."
            }
        }

        stage('Tests') {
            steps {
                echo "🧪 Exécution des tests..."
            }
        }

        stage('Analyse qualité (optionnel)') {
            steps {
                echo "📊 Analyse de la qualité..."
            }
        }

        stage('Post Actions') {
            steps {
                echo "🎉 Pipeline terminé avec SUCCÈS"
            }
        }
    }
}
