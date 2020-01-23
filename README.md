Rest Consumer
=============

This Spring Boot application launches a simple Rest Service that interacts with external APIs.

## Configuration

The only configuration that you need to perform is to modify the application properties file adding the url:

```yaml
operations.restURL: https://gturnquist-quoters.cfapps.io/api/random
```

## Usage

Currently, there are two methods:

1. Simple get: This endpoint performs a get in `${operations.restURL}`.

```bash
curl ${resCustomerURL}/api/service/get
```

2. Infinite loop get: This endpoint performs get operations continuously on `${operations.restURL}`.

```bash
curl ${resCustomerURL}/api/service/multipleGet
```


