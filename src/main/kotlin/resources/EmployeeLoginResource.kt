package resources

import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response
import model.EmployeeData
import services.Employee


@Path("/employee")
class EmployeeLoginResource {

    private val employeeService = Employee()

    @POST
    @Path("/login")
    fun login(employeeData: EmployeeData): Response {
        return if (employeeService.validateCredentials(employeeData.userName, employeeData.password)) {
            Response.ok(mapOf("message" to "Login successful")).build()
        } else {
            Response.status(Response.Status.UNAUTHORIZED)
                .entity(mapOf("message" to "Invalid username or password"))
                .build()
        }
    }
}
