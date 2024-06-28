package jp.ac.it_college.std.s23018.messageboard.presentaion.config

import ch.qos.logback.classic.pattern.MessageConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class KotlinSerialization : WebMvcConfigurer {
    @OptIn(ExperimentalStdlibApi::class)
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(0,KotlinSerializationJsonHttpMessageConverter(
            Json {
                ignoreUnknownKeys = true
                explicitNulls = false
                namingStrategy = JsonNamingStrategy.SnakeCase
            }
        ))
    }
}