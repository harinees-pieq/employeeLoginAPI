package services

import dao.EmployeeList
import model.EmployeeData
import org.slf4j.LoggerFactory

class Employee {
    private val logger = LoggerFactory.getLogger(Employee::class.java)

    fun validateCredentials(userName: String, password: String): Boolean {
        logger.info("Validating user: $userName with password: $password")
        val user = EmployeeList.employees.find { it.userName == userName }
        val isValid = user?.password == password
        logger.info("Validation result: $isValid")
        return isValid
    }
}
