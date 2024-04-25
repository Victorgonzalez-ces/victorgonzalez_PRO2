using ProyectoPrueba.Components.Models;

namespace ProyectoPrueba.Components.Services
{
    public interface IEmailService
    {
        Task SendEmailAsync(MailRequest request);
    }
}
