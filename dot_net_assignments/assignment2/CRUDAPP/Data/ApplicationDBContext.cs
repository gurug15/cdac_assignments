using CRUDAPP.Models.Entities;
using Microsoft.EntityFrameworkCore;

namespace CRUDAPP.Data
{
    public class ApplicationDBContext: DbContext
    {
        public ApplicationDBContext(DbContextOptions<ApplicationDBContext>  options) : base(options)
        {
            
        }

        public DbSet<Employee> Employees{ get; set; }
    }
}
