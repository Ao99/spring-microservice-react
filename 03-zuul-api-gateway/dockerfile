FROM amazoncorretto:11 
VOLUME /tmp
COPY target/flow-zuul-api-gateway-0.0.1-SNAPSHOT.jar ZuulApiGateway.jar 
ENTRYPOINT ["java","-jar","ZuulApiGateway.jar"] 