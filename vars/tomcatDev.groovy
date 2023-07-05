def call (creds,ip,warfile){
   //  install ssh agent plugin
   sshagent(['creds']) {
               // copy war file to tomcat-dev server
                sh "scp -o StrictHostKeyChecking=no target/${warfile} ubuntu@${ip}:/opt/tomcat9/webapps"
                
                sh "ssh ubuntu@${ip} /opt/tomcat9/bin/shutdown.sh"
                sh "ssh ubuntu@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
