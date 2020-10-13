using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class registrar : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            conexion.InsertarUsuario(this.TextBox3.Text, this.TextBox4.Text, this.TextBox5.Text, this.TextBox6.Text,2);
        }
    }
}