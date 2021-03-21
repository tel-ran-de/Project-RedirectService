package de.telran.project_redirect_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedirectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedirectServiceApplication.class, args);
	}

}
/*
 :: Spring Boot ::                (v2.4.4)

2021-03-21 00:50:59.787  INFO 9660 --- [  restartedMain] d.t.p.RedirectServiceApplication         : Starting RedirectServiceApplication using Java 1.8.0_281 on win10Java with PID 9660 (C:\Programming\Project-RedirectService\target\classes started by Evgenij in C:\Programming\Project-RedirectService)
2021-03-21 00:50:59.787  INFO 9660 --- [  restartedMain] d.t.p.RedirectServiceApplication         : No active profile set, falling back to default profiles: default
2021-03-21 00:50:59.877  INFO 9660 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2021-03-21 00:50:59.877  INFO 9660 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2021-03-21 00:51:00.865  INFO 9660 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-03-21 00:51:00.884  INFO 9660 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 13 ms. Found 0 JPA repository interfaces.
2021-03-21 00:51:01.744  INFO 9660 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-03-21 00:51:01.764  INFO 9660 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-03-21 00:51:01.764  INFO 9660 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.44]
2021-03-21 00:51:01.886  INFO 9660 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-03-21 00:51:01.886  INFO 9660 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2009 ms
2021-03-21 00:51:01.986  WARN 9660 --- [  restartedMain] ConfigServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'inMemoryDatabaseShutdownExecutor' defined in class path resource [org/springframework/boot/devtools/autoconfigure/DevToolsDataSourceAutoConfiguration.class]: Unsatisfied dependency expressed through method 'inMemoryDatabaseShutdownExecutor' parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceConfiguration$Hikari.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.zaxxer.hikari.HikariDataSource]: Factory method 'dataSource' threw exception; nested exception is org.springframework.boot.autoconfigure.jdbc.DataSourceProperties$DataSourceBeanCreationException: Failed to determine a suitable driver class
2021-03-21 00:51:01.986  INFO 9660 --- [  restartedMain] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
2021-03-21 00:51:02.018  INFO 9660 --- [  restartedMain] ConditionEvaluationReportLoggingListener :

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2021-03-21 00:51:02.045 ERROR 9660 --- [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   :

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class


Action:

Consider the following:
	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).


Process finished with exit code 0


 */
