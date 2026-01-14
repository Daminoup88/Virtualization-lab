# Setup Actions

- Start minikube:
	```sh
	minikube start
	```
- Deploy myservice:
	```sh
	kubectl apply -f myservice-deployment.yml
	```
- Deploy myservice2:
	```sh
	kubectl apply -f myservice-deployment2.yml
	```
- Create myservice service:
	```sh
	kubectl apply -f myservice-service.yml
	```
- Create myservice2 service:
	```sh
	kubectl apply -f myservice-service2.yml
	```
- Apply ingress configuration:
	```sh
	kubectl apply -f ingress.yml
	```
- Enable ingress addon:
	```sh
	minikube addons enable ingress
	```
- On Linux: edit the `/etc/hosts` file and add at the bottom values for: 

    IngressAddress myservice.info

    Where address is given by:
    ```
    minikube ip
    ```

    On Mac: edit the `/etc/hosts` file and add at the bottom values for: 

    127.0.0.1 myservice.info


    Then check in your Web browser: 

    http://myservice.info/

    On Windows : edit the `c:\windows\system32\drivers\etc\hosts` file, add 

    `127.0.0.1 myservice.info`
- Launch minikube tunnel:
    ```sh
    minikube tunnel
    ```
- Test services:
	- http://myservice.info/
	- http://myservice.info/service2

- Delete resources:
    ```sh
    kubectl delete -f ingress.yml
    kubectl delete -f myservice-service.yml
    kubectl delete -f myservice-service2.yml
    kubectl delete -f myservice-deployment.yml
    kubectl delete -f myservice-deployment2.yml
    ```

- Stop minikube:
    ```sh
    minikube stop
    ```