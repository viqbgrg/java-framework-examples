package com.github.viqbgrg.testing.context

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spock.mock.DetachedMockFactory

import java.util.concurrent.Executor

@CompileStatic
@Configuration
class TestConfig {
  @Bean
  Executor executor() {
    new DetachedMockFactory().Stub(Executor)
  }
}

