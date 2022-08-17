def call() {
    echo "building the docker images"
    withCredentials([usernamePassword(credentialsId:'docker_hub_id',usernameVariable: 'USER',passwordVariable: "PWD")]){
        sh 'docker build -t siddheshjungade/demojava-app .'
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh 'docker push siddheshjungade/demojava-app'
    }
}
