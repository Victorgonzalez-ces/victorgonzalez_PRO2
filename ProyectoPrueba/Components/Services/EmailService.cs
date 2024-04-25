namespace ProyectoPrueba.Components.Services

{
    using System;
    using MimeKit;
    using ProyectoPrueba.Components.Models;
    using MailKit.Net.Smtp;
    using Microsoft.Extensions.Options;
    using MailKit.Security;

    public class EmailService : IEmailService
    {
        private readonly SmtpSettings _smtpSettings;

        public EmailService(IOptions<SmtpSettings> smtpSettings)
        {
            _smtpSettings = smtpSettings.Value;
        }
        public async Task SendEmailAsync(MailRequest request)
        {
            
            try
            {
                var message = new MimeMessage();

                message.From.Add(new MailboxAddress(_smtpSettings.SenderName, _smtpSettings.SenderEmail));
                message.To.Add(new MailboxAddress("victor.gonzalez@cesjuanpablosegundo.es", request.Email));
                message.Subject = request.Subject;
                message.Body = new TextPart("html") { Text = request.Body };

                using (var client = new SmtpClient())
                {
                    await client.ConnectAsync(_smtpSettings.Server,_smtpSettings.Port, SecureSocketOptions.Auto);
                    await client.AuthenticateAsync(_smtpSettings.Username, _smtpSettings.Password);
                    await client.SendAsync(message);
                    await client.DisconnectAsync(true);
                }   
            }
            catch (Exception) 
            {
                throw;
            }

        }
    }
}
