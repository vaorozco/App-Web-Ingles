using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class BancoFonemas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (ControladorGeneral.Instance.usuario.tipousuario == "2")
            {
                ImageButton11.Visible = false;
            }
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
            ConexionSQL conexion = new ConexionSQL();
            List<Fonema> fonemas = conexion.SeleccionarFonemas2();
            for (int i = 0; i < fonemas.Count; i++)
            {
                ImageButton imageButton = new ImageButton();
                //FileInfo fileInfo = new FileInfo(strFileName);
                System.Drawing.Image imagen = byteArrayToImage(fonemas[i].imagen);
                string folderPath = Server.MapPath("~/Recursos/");
                imagen.Save(folderPath + fonemas[i].nombre + ".png");


                imageButton.ImageUrl = "~/Recursos/"+fonemas[i].nombre+".png";
                imageButton.Width = 120;
                imageButton.Height = 120;
                imageButton.BorderWidth = 10;
                imageButton.BorderColor = System.Drawing.Color.White;
                imageButton.ID = fonemas[i].nombre;
                imageButton.Click += new System.Web.UI.ImageClickEventHandler(Imagen_Click);
                //imageButton.Attributes.Add("ID", strFileName);
                //imageButton.Attributes.Add("class", "imgOne");
                imageButton.Attributes.Add("runat", "server");
                //imageButton.Attributes.Add("OnClick", "ImagenClick");
                this.Panel2.Controls.Add(imageButton);
            }
        }

        public System.Drawing.Image byteArrayToImage(byte[] bytesArr)
        {
            using (MemoryStream memstr = new MemoryStream(bytesArr))
            {
                System.Drawing.Image img = System.Drawing.Image.FromStream(memstr);
                return img;
            }
        }

        protected void Imagen_Click(object sender, ImageClickEventArgs e)
        {
            ImageButton button = (ImageButton)sender;
            ControladorUI.Instance.IDFonema = button.ID;
            Response.Redirect("ClickFonema.aspx");
        }

        protected void ImageButton8_Click(object sender, ImageClickEventArgs e)
        {
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