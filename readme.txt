springmvc+mybatis+mysql
以Dept部门为例子
Consumer消费者（Client）通过Rest调用Provider提供者（Service）提供的服务
一个Project带有多个子模块Module

总父工程
通用模块api
服务提供者Provide
服务消费者Consumer


【1】Eureka服务注册
microservicecloud-eureka-7001
microservicecloud-provider-dept-8001
【2】Eureka服务发现
microservicecloud-eureka-7001
microservicecloud-provider-dept-8001
microservicecloud-consumer-dept-80
【3】Eureka集群配置
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-8001


【4】Ribbon负载均衡
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-8001
microservicecloud-provider-dept-8002
microservicecloud-provider-dept-8003
microservicecloud-consumer-dept-80


【5】Feign负载均衡
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-8001
microservicecloud-provider-dept-8002
microservicecloud-provider-dept-8003
microservicecloud-consumer-dept-feign


【6】Hystrix服务熔断（Consumer通过Eureka服务访问Dept）
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-consumer-dept-80
microservicecloud-provider-dept-hystrix-8001


【7】Hystrix服务降级（Consumer通过Eureka服务访问Dept，中途故意关掉8001服务）
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-8001
microservicecloud-consumer-dept-feign


【8】服务监控hystrixDashboard
microservicecloud-consumer-hystrix-dashboard
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-hystrix-8001


【9】zuul路由网关访问映射（三个集群+1个提供者+1个路由）
microservicecloud-eureka-7001
microservicecloud-eureka-7002
microservicecloud-eureka-7003
microservicecloud-provider-dept-8001
microservicecloud-zuul-gateway-9527


【10】SpringCloud Config服务端从GitHub上获取配置
microservicecloud-config-3344
11 客户端3355访问（服务端3344从GitHub上获取配置信息）
microservicecloud-config-client-3355
microservicecloud-config-3344
12 Consumer通过Eureka服务访问Dept。（Dept通过Config服务端注册到Eureka）
microservicecloud-config-consumer-dept-client-80
microservicecloud-config-dept-client-8001
microservicecloud-config-eureka-client-7001
microservicecloud-config-3344








