using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class EmployeesController : Controller
    {
        // No need to maintain a separate static list here anymore

        // GET: EmployeesController
        public ActionResult Index()
        {
            var employees = Employee.GetAllEmployees();
            return View(employees);
        }

        // GET: EmployeesController/Details/5
        public ActionResult Details(int id)
        {
            try
            {
                var employee = Employee.GetSingleEmployee(id);
                return View(employee);
            }
            catch (Exception ex)
            {
                // Optionally handle not found case, e.g. show error view or redirect
                return NotFound(ex.Message);
            }
        }

        // GET: EmployeesController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeesController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Employee employee)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    Employee.InsertEmployee(employee);
                    return RedirectToAction(nameof(Index));
                }
                return View(employee);
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("", ex.Message);
                return View(employee);
            }
        }

        // GET: EmployeesController/Edit/5
        public ActionResult Edit(int id)
        {
            try
            {
                var employee = Employee.GetSingleEmployee(id);
                return View(employee);
            }
            catch (Exception ex)
            {
                return NotFound(ex.Message);
            }
        }

        // POST: EmployeesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Employee emp)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    Employee.UpdateEmployee(emp);
                    return RedirectToAction(nameof(Index));
                }
                return View(emp);
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("", ex.Message);
                return View(emp);
            }
        }

        // GET: EmployeesController/Delete/5
        public ActionResult Delete(int id)
        {
            try
            {
                var employee = Employee.GetSingleEmployee(id);
                return View(employee);
            }
            catch (Exception ex)
            {
                return NotFound(ex.Message);
            }
        }

        // POST: EmployeesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                Employee.DeleteEmployee(id);
                return RedirectToAction(nameof(Index));
            }
            catch (Exception ex)
            {
                ModelState.AddModelError("", ex.Message);
                // Reload employee to show in view if deletion failed
                var employee = Employee.GetSingleEmployee(id);
                return View(employee);
            }
        }
    }
}
