using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class GestionarUsuarios : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            if (!this.IsPostBack)
            {
                DataTable dt = conexion.SeleccionarUsuario();
                this.GridView1.DataSource = dt;
                this.GridView1.DataBind();
            }
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            conexion.InsertarUsuario(TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, int.Parse(DropDownList1.SelectedValue));
            Page.Response.Redirect(Page.Request.Url.ToString(), true);
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            TextBox1.Text = GridView1.SelectedRow.Cells[3].Text;
            TextBox2.Text = GridView1.SelectedRow.Cells[4].Text;
            TextBox3.Text = GridView1.SelectedRow.Cells[5].Text;
            TextBox4.Text = GridView1.SelectedRow.Cells[6].Text;
        }

        protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            conexion.ModificarUsuario(int.Parse(GridView1.SelectedRow.Cells[1].Text),TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, int.Parse(DropDownList1.SelectedValue));
            Page.Response.Redirect(Page.Request.Url.ToString(), true);
        }

        protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            conexion.BorrarUsuario(int.Parse(GridView1.SelectedRow.Cells[1].Text));
            Page.Response.Redirect(Page.Request.Url.ToString(), true);
        }
    }
}