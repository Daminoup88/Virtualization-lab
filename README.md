# Setup Actions

- Start minikube:
	```sh
	minikube start
	```
- Deploy myservice:
	```sh
	kubectl apply -f front-back-app.yml
	```
- Enable ingress addon:
	```sh
	minikube addons enable ingress
	```
- Apply ingress configuration:
	```sh
	kubectl apply -f ingress.yml
	```
- Launch minikube tunnel:
    ```sh
    minikube tunnel
    ```
- Test services:
	- http://front-end.localhost

- Delete resources:
    ```sh
    kubectl delete -f ingress.yml
    kubectl delete -f front-back-app.yml
    ```

- Stop minikube:
    ```sh
    minikube stop
    ```