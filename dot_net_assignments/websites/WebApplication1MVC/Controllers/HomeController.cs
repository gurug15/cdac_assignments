using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using WebApplication1MVC.Models;

namespace WebApplication1MVC.Controllers
{
    
    /*
       -controller name cane be anything but shoud be ending with Controller
       -
     */
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        
        // ILogger 
        public HomeController(ILogger<HomeController> logger)
        {
            //DI ctor injection
            _logger = logger;
        }


        /*
         *
         *IActionResult
         *-IActionResult is an parent interface of ActionResult which is parent of ViewResult
         *-why IActionResult cause we mi
         *
         *
         *Readup on deriverd classes of ActionResult ( at least 10)
         *
         * if view name is not returnd { return View("AnyName"); }it takes function name as Index 
         * index and privacy are put in home folder in view folder and error is in shared folder WHY?
         * 
         */
        public IActionResult Index()
        {
            return View(); // return View("AnyName");
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
