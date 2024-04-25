namespace ProyectoPrueba.Components
{
    using Microsoft.AspNetCore.Builder;
    using Microsoft.AspNetCore.Hosting;
    using Microsoft.Extensions.Configuration;
    using Microsoft.Extensions.DependencyInjection;
    using Microsoft.Extensions.Hosting;
    using ProyectoPrueba.Components.Models;
    using ProyectoPrueba.Components.Services;

    public class Startup
    {
        public IConfiguration Configuration { get; }

        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        // Este método es utilizado por el tiempo de ejecución para configurar el pipeline de solicitudes HTTP.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapBlazorHub(); // Mapea el componente de Blazor Hub
                endpoints.MapFallbackToPage("/_Host"); // Mapa de fallback a la página _Host
            });
        }

        // Este método es utilizado para agregar servicios al contenedor de inyección de dependencias.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddRazorPages(); // Agrega servicios de Razor Pages
            services.AddServerSideBlazor(); // Agrega servicios de Blazor del lado del servidor
            services.Configure<SmtpSettings>(Configuration.GetSection("SmtpSettings"));
            services.AddSingleton<IEmailService , EmailService>();
            // Aquí puedes agregar otros servicios necesarios para tu aplicación
            // Ejemplo: services.AddScoped<IMiServicio, MiServicio>();
        }
    }

}
