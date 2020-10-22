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
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        protected void TextBox1_TextChanged1(object sender, EventArgs e)
        {
            TextBox1.Text = "";
        }

        protected void Registrarse_Click(object sender, EventArgs e)
        {
            Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script>window.open('registrar.aspx','ventana1','width = 450, height = 400, scrollbars = NO');</script>");
            //Response.Redirect("registrar.aspx");
        }

        protected void Ingresar_Click(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            String isTrue = conexion.login(this.TextBox1.Text, this.TextBox2.Text);
            if (isTrue == "1")
            {
                String isTrueAdmin = conexion.loginAdmin(this.TextBox1.Text, this.TextBox2.Text);
                if(isTrueAdmin == "1")
                {
                    Response.Redirect("MenúAdmin.aspx");
                }
                else
                {
                    Response.Redirect("MenúEstudiante.aspx");
                }
            }
            else
            {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script>alert('Error con los datos ingresados');</script>");
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Page.ClientScript.RegisterStartupScript(this.GetType(), "Scripts", "<script>window.open('RecuperarContraseña.aspx','ventana1','width = 450, height = 170, scrollbars = NO');</script>");
        }
    }
}