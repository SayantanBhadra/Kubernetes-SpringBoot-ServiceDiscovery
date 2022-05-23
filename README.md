# Kubernetes-SpringBoot-ServiceDiscovery
This Applications won't run in Local Environment. They need Kubernetes Environment to run. I have tested them in minikube cluster.

Spring Cloud has introduced Kubernetes support that can access Kubernetes API and using it we can achieve the goal of service discovery using Kubernetes Service Objects. This approach is better than Eureka Server, another solution Spring Cloud Provides, in the sense, we don't need to create a dedicated application only for service discovery in ****Kubernetes environment****, instead we can use Kubernetes provided in-built service discovery mechanism.

Please note, along with programming, this approach also needs some extra Kubernetes configuration. Three things we need to create in Kubernetes:
1. A Role: A Role will give the spring cloud Kubernetes component necessary access to get all the resource information it needs.
2. A Service Account: It is basically a functional id. Applications that intends to use built in service discovery, need to use this service account.
3. Role Binding: It basically binds the Role with the Service Account so that all applications will get the access as defined in the role. 

Most of the example, I got in the internet, was using default namespace, but in enterprise world, it won't work, because giving access to default namespace is a  very bad idea from security perspective. Hence I created separate namespace and confined the whole approach in that namespace only.

**Kubernetes Steps:**
1. Create a separate namespace
    kubectl create namespace <namespace-name>
2. Create a role in that namespace
    a role that will give fetch, watch and list access to all services, pods, config maps, secrets and endpoints within the namespace.
3. Create a service account in that namespace
    This service account name will be used in deployment yaml file
4. Bind the role and service account using rolebinding.

**Java Steps:**
1. Add Spring Cloud Kubernetes dependency in pom.xml
    Mainly __spring-cloud-starter-kubernetes-client-all__ and __spring-cloud-starter-kubernetes-client-loadbalancer__.
2. Add __@EnableDiscoveryClient__ annotation in main application class
3. In the feign client, use the name of the service in the url.

