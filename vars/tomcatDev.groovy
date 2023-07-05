def call(ip,creds,warFile){
   //  install ssh agent plugin
    sshagent([creds]) {
      // copy war file to tomcat-dev server
      sh "scp -o StrictHostKeyChecking=no target/${warFile} ubuntu@${ip}:/opt/tomcat9/webapps"
      // restart tomcat 
      sh "ssh ubuntu@${ip} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ubuntu@${ip} /opt/tomcat9/bin/startup.sh"
    }
}
