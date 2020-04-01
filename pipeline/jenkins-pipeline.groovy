pipeline{
    agent{
        node{
            label "php"
        }
    }
     environment{
        APPLICATION_NAME = 'demo-php'
        DEV_PROJECT = "mydemo-php"
        BUILDCFG_NAME = "nodejs-webapp"
    }

    stages{
        stage('Build image'){
            steps{
                script{
                    openshiftBuild(buildConfig: 'demo-php', showBuildLogs: 'true')
                }
            }
        }

        stage('Deploy to DEV'){
            echo 'Deploying to DEV....'
            openshiftDeploy(deploymentConfig: 'demo-php')
        }

        stage('Promote from DEV to QA'){
            sleep 5
            echo 'Promoting to QA...'
        }

        stage('Wait for approval'){
            input 'Aprove to production?'
        }

        stage ('Promote from QA to Production'){
            sleep 3
            echo 'Promoting to production...'
        }
    }
    
}
