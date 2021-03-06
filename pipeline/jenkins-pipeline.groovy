pipeline{
    agent{
        node{
            label "maven"
        }
    }
    
    environment{
        APPLICATION_NAME = 'demo-php'
        DEV_PROJECT = "mydemo-php"
        BUILDCFG_NAME = "demo-php"
        GIT = "https://github.com/renatoppuccini/demo-php.git"
    }
    
    stages{
        stage('Delete buildconfig'){
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject(DEV_PROJECT) {
                            openshift.selector("all", [ template : BUILDCFG_NAME ]).delete()
                        }
                    }
                }
            }
        }

        stage('Create Image Builder') {
            when {
                expression {
                    openshift.withCluster() {
                        openshift.withProject(DEV_PROJECT) {
                            return !openshift.selector("bc", "${BUILDCFG_NAME}").exists();
                        }
                    }
                }
            }
           steps {
                script {
                    openshift.withCluster( "https://api.usa.puccini.redhat-demo.com:6443") {
                        openshift.withProject(DEV_PROJECT) {
                            openshift.newBuild("--name=${BUILDCFG_NAME}", "--image-stream=openshift/php:latest", GIT).logs("-f")
                        }
                    }
                }
            }
        }
    }

   
    
}
