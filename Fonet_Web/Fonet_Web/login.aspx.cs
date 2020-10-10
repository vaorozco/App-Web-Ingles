using System;
using System.Collections.Generic;
using System.Linq;
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
            Response.Redirect("registrar.aspx");
        }

        protected void Ingresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("MenúAdmin.aspx");
        }
    }
}