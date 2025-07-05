 namespace WebApplication1MVC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            WebApplicationBuilder builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();
            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseRouting();

            app.UseAuthorization();

            app.MapStaticAssets();

            /*mapcontroller route --name can be anything,
                creating a route variable called x-->id?
                    -like path localhost:1232/controller/action/x so here x is taken as an id
                    -Ex: 
                         -localhost:1234/employees/edit/123
                    -if ? is not provided and alsonot set ^ as above then it will give error so its like optional
                    -Ex:
                        -/emp/get/1 
                        -/emp/get
                    - the {controller = home} the home will be default if not privided Ex: localhost:123/{here if not provided it will take home as defaukt}

             */
            app.MapControllerRoute(
                name: "default",
                //pattern: "{controller=Default}/{action=Index}/{id?}/{a?}/{b?}")
                pattern: "{controller=Home}/{action=Index}/{id?}")
                .WithStaticAssets();

            app.Run();
        }
    }
}
