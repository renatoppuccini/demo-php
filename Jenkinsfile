
node('maven') {

    stage('Build image'){
        echo 'Building docker image....'
    }

    stage('Deploy to DEV'){
        echo 'Deploying to DEV....'
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
