package com.tutorial.spring.aop;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) //proxyTargetClass is for the using of cglib proxying
@ComponentScan("com.tutorial.spring.aop")
public class DemoConfig { }
