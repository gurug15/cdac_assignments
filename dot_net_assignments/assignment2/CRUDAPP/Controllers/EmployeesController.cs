using CRUDAPP.Data;
using CRUDAPP.Models;
using CRUDAPP.Models.Entities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace CRUDAPP.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeesController : ControllerBase
    {
        private readonly ApplicationDBContext dBContext;

        public EmployeesController(ApplicationDBContext dBContext)
        {
            this.dBContext = dBContext;
        }

        [HttpGet]
        public IActionResult GetAllEmps()
        {
            var allEmployees = dBContext.Employees.ToList();

            return Ok(allEmployees);
        }


        [HttpPost]
        public IActionResult AddEmployee(DTOEmployee empDto)
        {
            var EmployeeEntity = new Employee()
            { 
                Name = empDto.Name,
                Email = empDto.Email,
                Phone = empDto.Phone,
                Salary = empDto.Salary,
            };
             
            dBContext.Employees.Add(EmployeeEntity);
            dBContext.SaveChanges();
            return Ok(EmployeeEntity);
        } 
    }
}
