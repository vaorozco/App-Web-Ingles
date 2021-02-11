using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class Perfil : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (ControladorGeneral.Instance.usuario.tipousuario == "2")
            {
                ImageButton11.Visible = false;
            }
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
            TextBox1.Visible = false;
            TextBox2.Visible = false;
            TextBox3.Visible = false;
            TextBox4.Visible = false;
            Label8.Text = ControladorGeneral.Instance.usuario.nombre;
            Label9.Text = ControladorGeneral.Instance.usuario.apellido;
            Label10.Text = ControladorGeneral.Instance.usuario.correo;
            Label11.Text = ControladorGeneral.Instance.usuario.contraseña;
            Guardar.Visible = false;
            Cancelar.Visible = false;
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
            if (ControladorGeneral.Instance.usuario.tipousuario == "1")
            {
                Response.Redirect("MenúAdmin.aspx");
            }
            else
            {
                Response.Redirect("MenúEstudiante.aspx");
            }
        }

        protected void ImageButton11_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenúGestionar.aspx");
        }

        protected void ImageButton12_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("Perfil.aspx");
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            ControladorGeneral.Instance.usuario = null;
            Response.Redirect("login.aspx");
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            TextBox1.Visible = true;
            TextBox2.Visible = true;
            TextBox3.Visible = true;
            TextBox4.Visible = true;
            TextBox1.Text = ControladorGeneral.Instance.usuario.nombre;
            TextBox2.Text = ControladorGeneral.Instance.usuario.apellido;
            TextBox3.Text = ControladorGeneral.Instance.usuario.correo;
            TextBox4.Text = ControladorGeneral.Instance.usuario.contraseña;
            Label8.Visible = false;
            Label9.Visible = false;
            Label10.Visible = false;
            Label11.Visible = false;
            Modificar.Visible = false;
            Guardar.Visible = true;
            Cancelar.Visible = true;
        }

        protected void Button4_Click(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            conexion.ModificarUsuario(int.Parse(ControladorGeneral.Instance.usuario.id), TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, int.Parse(ControladorGeneral.Instance.usuario.tipousuario));
            ControladorGeneral.Instance.usuario.nombre = TextBox1.Text;
            ControladorGeneral.Instance.usuario.apellido = TextBox2.Text;
            ControladorGeneral.Instance.usuario.correo = TextBox3.Text;
            ControladorGeneral.Instance.usuario.contraseña = TextBox4.Text;
            ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Modifico el Usuario'); window.location='" + Request.ApplicationPath + "Perfil.aspx';", true);
        }

        protected void Cancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Perfil.aspx");
        }
    }
}