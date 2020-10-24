using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class RecuperarContraseña : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                RecuperarC recuperarc = conexion.recuperarContraseña(TextBox1.Text);
                if (recuperarc.isTrue == "1")
                {
                    using (MailMessage mail = new MailMessage())
                    {
                        mail.From = new MailAddress("appfonet@gmail.com");
                        mail.To.Add(TextBox1.Text);
                        mail.Subject = "Fonet - Recuperar Contraseña";
                        mail.Body = "¡Hola " + recuperarc.nombre + "!\n" + "Te enviamos este correo porque solicitaste recuperar tu contraseña. Tu contraseña es: " + recuperarc.contraseña;
                        mail.IsBodyHtml = true;
                        //mail.Attachments.Add(new Attachment("C:\\file.zip"));

                        using (SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587))
                        {
                            smtp.Credentials = new NetworkCredential("appfonet@gmail.com", "1234fonet5678");
                            smtp.EnableSsl = true;
                            smtp.Send(mail);
                        }
                    }
                }
                else
                {
                    //Label2.Visible = true;
                    Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script>alert('Error con los datos ingresados');</script>");
                }
            }
            catch
            {
                Console.WriteLine("No avanzo");
            }
            
        }
    }
}