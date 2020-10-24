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
                byte[] sonido;
                BinaryReader br = new BinaryReader(FileUpload2.PostedFile.InputStream);
                sonido = br.ReadBytes((int)FileUpload2.PostedFile.InputStream.Length);

                int tamaño = FileUpload1.PostedFile.ContentLength;
                byte[] imagenoriginal = new byte[tamaño];
                FileUpload1.PostedFile.InputStream.Read(imagenoriginal, 0, tamaño);
                Bitmap ImagenOriginalBinaria = new Bitmap(FileUpload1.PostedFile.InputStream);

                conexion.InsertarPalabra(TextBox1.Text, imagenoriginal, sonido);
                conexion.InsertarPalabraXFonema(DropDownList1.SelectedValue, TextBox1.Text);
                Page.Response.Redirect(Page.Request.Url.ToString(), true);
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
                TextBox1.Text = palabra.nombre;
                System.Drawing.Image imagen = System.Drawing.Image.FromStream(palabra.imagen);
                string folderPath = Server.MapPath("~/Recursos/");
                imagen.Save(folderPath + "Prueba.png");
                File.WriteAllBytes(folderPath + "Prueba.wav", palabra.sonido);
                Label1.Text = folderPath + "Prueba.wav";
                Image1.ImageUrl = "~/Recursos/Prueba.png";
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
                if (Label1.Text == "Ruta")
                {
                    string folderPath = Server.MapPath("~/Recursos/");
                    if (!Directory.Exists(folderPath))
                    {
                        Directory.CreateDirectory(folderPath);
                    }
                    FileUpload2.SaveAs(folderPath + Path.GetFileName(FileUpload2.FileName));
                    _sm.SoundLocation = folderPath + Path.GetFileName(FileUpload2.FileName);
                    _sm.PlaySync();
                }
                else
                {
                    _sm.SoundLocation = Label1.Text;
                }
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
                byte[] sonido;
                BinaryReader br = new BinaryReader(FileUpload2.PostedFile.InputStream);
                sonido = br.ReadBytes((int)FileUpload2.PostedFile.InputStream.Length);

                int tamaño = FileUpload1.PostedFile.ContentLength;
                byte[] imagenoriginal = new byte[tamaño];
                FileUpload1.PostedFile.InputStream.Read(imagenoriginal, 0, tamaño);
                Bitmap ImagenOriginalBinaria = new Bitmap(FileUpload1.PostedFile.InputStream);

                conexion.ModificarPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text), TextBox1.Text, imagenoriginal, sonido);
                Page.Response.Redirect(Page.Request.Url.ToString(), true);
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
                conexion.BorrarPalabra(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                Page.Response.Redirect(Page.Request.Url.ToString(), true);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
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