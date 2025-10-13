 # Micronaut Utility Beans
![Build](https://github.com/trevorism/micronaut-utility-beans/actions/workflows/build.yml/badge.svg)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/micronaut-utility-beans)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/micronaut-utility-beans)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/micronaut-utility-beans)
 
Latest [Version](https://github.com/trevorism/micronaut-utility-beans/releases/latest)
 
This java library injects authentication tokens from incoming requests into outgoing requests. 
It is useful for microservice to microservice communication where the authentication token needs to be passed along.
 
## How to Use 

```java
@Inject
SecureHttpClient passThruSecureHttpClient;
```

## How to Build
`gradle clean build`