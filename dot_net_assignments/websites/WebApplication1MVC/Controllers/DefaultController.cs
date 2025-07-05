using Microsoft.AspNetCore.Mvc;

namespace WebApplication1MVC.Controllers
{
    public class DefaultController : Controller
    {
        public IActionResult Index(int? id, int? a, int b)
        {
            //if (id == null)
            //    return NotFound();
            Console.WriteLine($"id: {id}, a:{a}, b:{b}");
            /*
                ViewBag

             */

            ViewBag.id = id;
            ViewBag.a = a;
            ViewBag.b = b;
          return View(ViewBag);
        }
        public IActionResult Index2(string name = "random")
        {

            ViewBag.name = name;
            return View(ViewBag);
        }
    }
}
