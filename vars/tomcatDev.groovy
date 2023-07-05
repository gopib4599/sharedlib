def call (creds,ip,warfile){
  sshagent(['creds']) {
                
                sh "scp -o StrictHostKeyChecking=no ${warfile} ubuntu@ip:/opt/tomcat9/webapps"
                
                sh "ssh ubuntu@${ip} /opt/tomcat9/bin/shutdown.sh"
                sh "ssh ubuntu@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
