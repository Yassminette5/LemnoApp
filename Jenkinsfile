pipeline {
    agent any

    // Déclenche automatiquement le pipeline lorsqu'un nouveau commit est détecté sur le dépôt Git
    triggers {
        // Vérifie le dépôt toutes les minutes
        // Format cron Jenkins : minute heure jour_mois mois jour_semaine
        pollSCM('* * * * *')
    }

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "🔧 Build en cours"
            }
        }

        stage('Tests') {
            steps {
                echo "test automatique 1 " 
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
