import io.dropwizard.core.Configuration
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Environment
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import resources.EmployeeLoginResource
import org.eclipse.jetty.servlets.CrossOriginFilter
import java.util.EnumSet
import jakarta.servlet.DispatcherType
import jakarta.servlet.FilterRegistration


class Application : Application<Configuration>(){
    override fun run(configuration: Configuration, environment: Environment) {
        environment.objectMapper.registerKotlinModule()
        environment.objectMapper.registerModule(JavaTimeModule())

        val employeeResourceLogin = EmployeeLoginResource()
        environment.jersey().register(employeeResourceLogin)

        val cors = environment.servlets().addFilter("CORS", CrossOriginFilter::class.java)

        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*")
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin")
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD")
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true")

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType::class.java), true, "/*")
    }
    }


fun main(args: Array<String>) {
    Application().run(*args)
}
