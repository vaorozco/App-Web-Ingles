using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Media;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class ClickFonema : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(ControladorGeneral.Instance.usuario.tipousuario == "2")
            {
                ImageButton11.Visible = false;
            }
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
            ConexionSQL conexion = new ConexionSQL();
            Fonema fonema = conexion.SeleccionarFonema(int.Parse(ControladorUI.Instance.IDFonema));
            System.Drawing.Image imagen = byteArrayToImage(fonema.imagen);
            string folderPath = Server.MapPath("~/Recursos/");
            File.WriteAllBytes(folderPath + fonema.nombre + ".wav", fonema.sonido);
            Label5.Text = folderPath + fonema.nombre + ".wav";
            imagen.Save(folderPath + fonema.nombre + ".png");
            Image1.ImageUrl = "~/Recursos/" + fonema.nombre + ".png";
            Label3.Text = ControladorUI.Instance.IDFonema;

            List<Palabra> palabras = conexion.SeleccionarPalabras(int.Parse(ControladorUI.Instance.IDFonema));
            for (int i = 0; i < palabras.Count; i++)
            {
                Image image = new Image();
                Label label = new Label();
                ImageButton sonidob = new ImageButton();
                //FileInfo fileInfo = new FileInfo(strFileName);
                System.Drawing.Image imagen2 = byteArrayToImage(palabras[i].imagen);
                imagen2.Save(folderPath + palabras[i].nombre + ".png");
                File.WriteAllBytes(folderPath + palabras[i].nombre + ".wav", palabras[i].sonido);

                //Interfaz Grafica Dinamica
                label.Text = palabras[i].nombre;
                label.CssClass = "auto-style21";
                label.BorderWidth = 10;
                label.BorderColor = System.Drawing.Color.White;
                label.Width = 80;
                label.Height = 80;
                sonidob.ImageUrl = "~/Recursos/altavoz.png";
                sonidob.Width = 80;
                sonidob.Height = 80;
                sonidob.BorderWidth = 10;
                sonidob.BorderColor = System.Drawing.Color.White;
                sonidob.Click += new System.Web.UI.ImageClickEventHandler(Sonido_Click);
                sonidob.ID = palabras[i].nombre;


                image.ImageUrl = "~/Recursos/" + palabras[i].nombre + ".png";
                image.Width = 130;
                image.Height = 130;
                image.BorderWidth = 10;
                image.BorderColor = System.Drawing.Color.White;
                //image.ID = palabras[i].nombre;
                //imageButton.Click += new System.Web.UI.ImageClickEventHandler(Imagen_Click);
                //imageButton.Attributes.Add("ID", strFileName);
                //imageButton.Attributes.Add("class", "imgOne");
                image.Attributes.Add("runat", "server");
                //imageButton.Attributes.Add("OnClick", "ImagenClick");
                this.Panel2.Controls.Add(label);
                this.Panel2.Controls.Add(image);
                this.Panel2.Controls.Add(sonidob);
            }

        }

        protected void ImageButton13_Click(object sender, ImageClickEventArgs e)
        {
            SoundPlayer _sm = new SoundPlayer();
            _sm.SoundLocation = Label5.Text;
            _sm.PlaySync();
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            ControladorGeneral.Instance.usuario = null;
            Response.Redirect("login.aspx");
        }

        public System.Drawing.Image byteArrayToImage(byte[] bytesArr)
        {
            using (MemoryStream memstr = new MemoryStream(bytesArr))
            {
                System.Drawing.Image img = System.Drawing.Image.FromStream(memstr);
                return img;
            }
        }

        protected void Sonido_Click(object sender, ImageClickEventArgs e)
        {
            SoundPlayer _sm = new SoundPlayer();
            ImageButton button = (ImageButton)sender;
            string folderPath = Server.MapPath("~/Recursos/");
            string path = folderPath + button.ID + ".wav";
            _sm.SoundLocation = path;
            _sm.PlaySync();
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

    }
}