package io.jongyun.learndgs.datsource

import com.github.javafaker.Faker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataSourceConfig {

    @Bean
    fun faker(): Faker {
        return Faker()
    }
}