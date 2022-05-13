"# PMSapplication" 

___________________________________________________________________________________________

We are using 2 way for deploying our project PMS:

1. ) using docker-compose yaml file 
2. ) using minikube kubernate cluster with ec2 instance (AWS)


__________________________________________________________________________

1st way :------------>
_________


Dockerfile :

FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8082
ADD build/libs/PropertyManagementSystem-1-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]

docker-compose.yaml :

version: '3.9'

services:
  API:
    image: shubham98765/api
    # build: 
    #   context: .
    ports:
      - "8082:8082"
    depends_on:
       PostgreSQL:
        condition: service_healthy
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://PostgreSQL:5432/postgres
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=root
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
  PostgreSQL:
    image: postgres
    volumes:
      - db_data:/var/lib/postgresql/data
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=root
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U shubham"]
      interval: 10s
      timeout: 5s
      retries: 5
volumes:
  db_data: {}  
  
  
  _______________________________________________________________________________________

used commands :

1. docker-compose up
2. docker ps
3. docker images


We can access our deployed application by using link :

aws publicip address : port no 

____________________________________________________________________________   

2nd way :-------->

By using minikube cluster : 


there are 2 deployment yaml format files and 2 service yamal format files :


1) db-deployment.yaml 

apiVersion: apps/v1
kind: Deployment
metadata:
  name: postgres
spec:
  selector: 
    matchLabels:
      app: postgres
  strategy:
    type: Recreate
  replicas: 1  
  template:
    metadata:
      labels: 
        app:  postgres
    spec:
      containers:
        - name:  postgres
          image: postgres
          env:
            - name: POSTGRES_PASSWORD
              value: root
            - name: POSTGRES_USER
              value: postgres
          ports:
            - containerPort: 5432
          
 2.) db-service.yaml 

apiVersion: v1
kind: Service
metadata:
  name: dbservice
spec:
  type: ClusterIP
  ports:
    - port: 5432
      targetPort: 5432
  selector:
    app: postgres
    


 3.) deployment.yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: springboot-kubernetes
spec:
  selector:
    matchLabels:
      app: springboot-kubernetes
  replicas: 2
  template:
    metadata:
      labels:
        app: springboot-kubernetes
    spec:
      containers:
        - name: springboot-kubernetes
          image: shubham98765/api
          ports:
            - containerPort: 8082
          env:
            - name: SPRING_DATASOURCE_URL
              value: jdbc:postgresql://10.109.171.184:5432/postgres
            - name: SPRING_DATASOURCE_USERNAME
              value: postgres
            - name: SPRING_DATASOURCE_PASSWORD
              value: root  
            - name: SPRING_JPA_HIBERNATE_DDL_AUTO
              value: update

4.) service.yaml 


apiVersion: v1
kind: Service
metadata:
  name: springboot-kubernetes-service
spec:
  ports:
    - protocol: "TCP"
      port: 8082          # The port inside the cluster
      targetPort: 8082    # The port exposed by the service
  type: NodePort          # Type of service
  selector:
    app: springboot-kubernetes


_____________________________________________________________________________

comands used:

1.)  minikube start --vm-driver=none
2.)  minikube status 
3.)  minikube dashboard
4.)  kubectl apply -f <file-name.yaml>
5.)  kubectl get pod
6.)  kubectl get service
7.)  kubectl get deployment
8.)  kubectl get all

  

    
