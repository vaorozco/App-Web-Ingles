using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class MenuGestionar : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void ImageButton3_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("GestionarPalabra.aspx");
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("GestionarUsuarios.aspx");
        }

        protected void ImageButton2_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("GestionarFonema.aspx");
        }

        protected void ImageButton10_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenúAdmin.aspx");
        }

        protected void ImageButton11_Click(object sender, ImageClickEventArgs e)
        {
            Response.Redirect("MenuGestionar.aspx");
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect("login.aspx");
        }
    }
}