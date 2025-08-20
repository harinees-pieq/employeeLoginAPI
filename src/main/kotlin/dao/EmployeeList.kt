package dao

import model.EmployeeData

class EmployeeList {
    companion object {
        val employees = listOf(
            EmployeeData("harinee", "1234"),
            EmployeeData("gomathi", "abcd"),
            EmployeeData("dhivya", "admin"),
            EmployeeData("shanmugam", "abc12")
        )
    }
}
