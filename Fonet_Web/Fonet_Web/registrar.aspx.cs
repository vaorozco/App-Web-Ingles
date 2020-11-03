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
            if(TextBox4.Text == TextBox5.Text)
            {
                conexion.InsertarUsuario(this.TextBox1.Text, this.TextBox2.Text, this.TextBox3.Text, this.TextBox4.Text, 2);
            }
            else
            {
                Label7.Visible = true;
            }
            
        }
    }
}