using System;
using System.Collections.Generic;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Media;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class GestionarPalabra : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
            if (!this.IsPostBack)
            {
                DataTable dt = conexion.SeleccionarPalabra();
                this.GridView1.DataSource = dt;
                this.GridView1.DataBind();
                List<ListItem> lista = conexion.SeleccionarFonemas();
                for(int i=0; i <lista.Count; i++)
                {
                    DropDownList1.Items.Add(lista[i]);
                }
            }
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                byte[] sonido = ControladorUI.Instance.get_sonido();
                byte[] imagen = ControladorUI.Instance.get_imagen();

                string isTrue = conexion.InsertarPalabra(TextBox1.Text, imagen, sonido);
                string isTrue2 = conexion.InsertarPalabraXFonema(int.Parse(DropDownList1.SelectedValue), TextBox1.Text);
                if (isTrue == "0" || isTrue2 == "0")
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('La palabra no se guardó ya existe');", true);
                }
                else
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Registro la Palabra'); window.location='" + Request.ApplicationPath + "GestionarPalabra.aspx';", true);
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
                ConexionSQL conexion = new ConexionSQL();
                Palabra palabra = new Palabra();
                palabra = conexion.SeleccionarPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                palabra.fonema = conexion.SeleccionarFonemaPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                ControladorUI.Instance.set_sonido(palabra.sonido);
                ControladorUI.Instance.set_imagen(palabra.imagen);
                TextBox1.Text = palabra.nombre;
                //System.Drawing.Image imagen = System.Drawing.Image.FromStream(fonema.imagen);
                System.Drawing.Image imagen = byteArrayToImage(palabra.imagen);
                string folderPath = Server.MapPath("~/Recursos/");
                imagen.Save(folderPath + palabra.nombre + ".png");
                File.WriteAllBytes(folderPath + palabra.nombre + ".wav", palabra.sonido);
                Label1.Text = folderPath + palabra.nombre + ".wav";
                Label5.Text = palabra.nombre + ".wav";
                Image1.ImageUrl = "~/Recursos/" + palabra.nombre + ".png";
                DropDownList1.SelectedValue = palabra.fonema;
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void ImageButton4_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                string folderPath = Server.MapPath("~/Recursos/");

                //Check whether Directory (Folder) exists.
                if (!Directory.Exists(folderPath))
                {
                    //If Directory (Folder) does not exists Create it.
                    Directory.CreateDirectory(folderPath);
                }

                //Save the File to the Directory (Folder).
                FileUpload1.SaveAs(folderPath + Path.GetFileName(FileUpload1.FileName));

                //Display the Picture in Image control.
                Image1.ImageUrl = "~/Recursos/" + Path.GetFileName(FileUpload1.FileName);

                int tamaño = FileUpload1.PostedFile.ContentLength;
                byte[] imagenoriginal = new byte[tamaño];
                FileUpload1.PostedFile.InputStream.Read(imagenoriginal, 0, tamaño);
                ControladorUI.Instance.set_imagen(imagenoriginal);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void ImageButton5_Click1(object sender, ImageClickEventArgs e)
        {
            try
            {
                SoundPlayer _sm = new SoundPlayer();
                _sm.SoundLocation = Label1.Text;
                _sm.PlaySync();
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
                byte[] sonido = ControladorUI.Instance.get_sonido();
                byte[] imagen = ControladorUI.Instance.get_imagen();

                conexion.ModificarPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text), TextBox1.Text, imagen, sonido);
                conexion.ModificarFonemaPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text), int.Parse(DropDownList1.SelectedValue));
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Modifico la Palabra'); window.location='" + Request.ApplicationPath + "GestionarPalabra.aspx';", true);
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
                conexion.BorrarPalabraFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                conexion.BorrarPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Elimino la Palabra'); window.location='" + Request.ApplicationPath + "GestionarPalabra.aspx';", true);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
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

        protected void ImageButton14_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                string folderPath = Server.MapPath("~/Recursos/");

                //Check whether Directory (Folder) exists.
                if (!Directory.Exists(folderPath))
                {
                    //If Directory (Folder) does not exists Create it.
                    Directory.CreateDirectory(folderPath);
                }

                //Save the File to the Directory (Folder).
                FileUpload2.SaveAs(folderPath + Path.GetFileName(FileUpload2.FileName));

                //Display the Picture in Image control.
                this.Label5.Text = FileUpload2.FileName;
                this.Label1.Text = folderPath + FileUpload2.FileName;

                byte[] sonido;
                BinaryReader br = new BinaryReader(FileUpload2.PostedFile.InputStream);
                sonido = br.ReadBytes((int)FileUpload2.PostedFile.InputStream.Length);
                ControladorUI.Instance.set_sonido(sonido);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
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