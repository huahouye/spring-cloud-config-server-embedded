
reference:

> https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_embedding_the_config_server

Should add `spring-cloud-starter-bootstrap` dependency in pom.xml file.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

## how to

Create a configuration file for this project.

```
$ mkdir -p $HOME/config-repo
$ cd $HOME/config-repo
$ echo info.foo: bar > application.properties
```

Start project:

```
mvn spring-boot:run
```

Test:

```
$ curl localhost:8080/spring-cloud-config-server-embedded/development

{"name":"spring-cloud-config-server-embedded","profiles":["development"],"label":null,"version":null,"state":null,"propertySources":[{"name":"file:/home/huahouye/config-repo/application.properties","source":{"info.foo":"bar"}}]}
```

```
$ curl localhost:8080/api/simple

simple test, barFromValue = bar, barFromEnv = bar
```