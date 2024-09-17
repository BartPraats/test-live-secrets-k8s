# test-live-secrets-k8s
Repository to test the integration between spring-boot:3 and spring-cloud-starter-kubernetes-client-config

# Run locally:

1. Run `mvn clean install`
2. Run `docker build --tag test-live-secrets-k8s:latest .`
3. Run `cd ./helm/test-live-secrets-k8s`
4. Run `helm upgrade --install --values values-dev.yaml --set secrets.someSecret=<override-value> test-live-secrets-k8s .`
5. Run `kubectl get pods` and look for your pod. Copy the pods name.
6. Run `kubectl port-forward <pod-name> 8080:8080`2
7. Browse to localhost:8080/v1/secret, and you should see the values passed in step 4.