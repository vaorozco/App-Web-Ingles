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
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
            if (!this.IsPostBack)
            {
                DataTable dt = conexion.SeleccionarUsuario();
                this.GridView1.DataSource = dt;
                this.GridView1.DataBind();
            }
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                string isTrue = conexion.InsertarUsuario(TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, int.Parse(DropDownList1.SelectedValue));
                if (isTrue == "0")
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('El usuario no se guardó ya existe');", true);
                }
                else
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se registro el usuario'); window.location='" + Request.ApplicationPath + "GestionarUsuarios.aspx';", true);
                }
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                TextBox1.Text = GridView1.SelectedRow.Cells[3].Text;
                TextBox2.Text = GridView1.SelectedRow.Cells[4].Text;
                TextBox3.Text = GridView1.SelectedRow.Cells[5].Text;
                TextBox4.Text = GridView1.SelectedRow.Cells[6].Text;
                DropDownList1.SelectedValue = GridView1.SelectedRow.Cells[2].Text;
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                conexion.ModificarUsuario(int.Parse(GridView1.SelectedRow.Cells[1].Text), TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, int.Parse(DropDownList1.SelectedValue));
                //Page.Response.Redirect(Page.Request.Url.ToString(), true);
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect","alert('Se Modifico el Usuario'); window.location='" +Request.ApplicationPath + "GestionarUsuarios.aspx';", true);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                conexion.BorrarUsuario(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Elimino el Usuario'); window.location='" + Request.ApplicationPath + "GestionarUsuarios.aspx';", true);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("login.aspx");
        }

        protected void ImageButton8_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("BancoFonemas.aspx");
        }

        protected void ImageButton9_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenúJuegos.aspx");
        }

        protected void ImageButton10_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenúAdmin.aspx");
        }

        protected void ImageButton11_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenúGestionar.aspx");
        }

        protected void ImageButton12_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Perfil.aspx");
        }
    }
}