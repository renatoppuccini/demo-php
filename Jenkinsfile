
node('maven') {

    stage('Build image'){
        echo 'Building docker image....'
        checkout scm
    }

    stage('Deploy to DEV'){
        echo 'Deploying to DEV....'
        sh "oc project php-pipeline"
        sh "oc new-app php~https://github.com/renatoppuccini/demo-php.git"
    }
    
    stage('Promote from DEV to QA'){
        echo 'Promoting to QA...'
    }

    stage('Wait for approval'){
        input 'Aprove to production?'
    }

    stage ('Promote from QA to Production'){
        echo 'Promoting to production...'
    }
    
}
