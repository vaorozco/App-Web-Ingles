using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Runtime.InteropServices;
using System.Media;
using System.Drawing;
using System.Data.SqlClient;
using System.Reflection.Emit;
using NAudio.Wave;

namespace Fonet_Web
{
    public partial class GestionarFonema: System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            if (!this.IsPostBack)
            {
                DataTable dt = conexion.SeleccionarFonema();
                this.GridView1.DataSource = dt;
                this.GridView1.DataBind();
            }
        }

        protected void ImageButton1_Click(object sender, ImageClickEventArgs e)
        {
            
            ConexionSQL conexion = new ConexionSQL();
            byte[] sonido;
            BinaryReader br = new BinaryReader(FileUpload2.PostedFile.InputStream);
            sonido = br.ReadBytes((int)FileUpload2.PostedFile.InputStream.Length);

            /*int tamaño = FileUpload1.PostedFile.ContentLength;
            byte[] imagenoriginal = new byte[tamaño];
            FileUpload1.PostedFile.InputStream.Read(imagenoriginal, 0, tamaño);*/

            int tamaño = ControladorUI.Instance.get_tamañoimagen();
            byte[] imagenoriginal = new byte[tamaño];
            ControladorUI.Instance.get_imagen().Read(imagenoriginal, 0, tamaño);
            //Bitmap ImagenOriginalBinaria = new Bitmap(FileUpload1.PostedFile.InputStream);
            try
            {
                conexion.InsertarFonema(TextBox1.Text, imagenoriginal, sonido);
                Page.Response.Redirect(Page.Request.Url.ToString(), true);
            }
            catch
            {
                Console.WriteLine("No se Pudo");
            }
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                ConexionSQL conexion = new ConexionSQL();
                Fonema fonema = new Fonema();
                fonema = conexion.SeleccionarFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                TextBox1.Text = fonema.nombre;
                System.Drawing.Image imagen = System.Drawing.Image.FromStream(fonema.imagen);
                string folderPath = Server.MapPath("~/Recursos/");
                imagen.Save(folderPath + "Prueba.png");
                File.WriteAllBytes(folderPath + "Prueba.wav", fonema.sonido);
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

                ControladorUI.Instance.set_imagen(FileUpload1.PostedFile.InputStream);
                ControladorUI.Instance.set_tamañoimagen(FileUpload1.PostedFile.ContentLength);
            }
            catch
            {
                Console.WriteLine("Falló");
            }
        }

        protected void ImageButton5_Click(object sender, ImageClickEventArgs e)
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

            SoundPlayer _sm = new SoundPlayer();
            _sm.SoundLocation = folderPath + Path.GetFileName(FileUpload2.FileName);
            _sm.PlaySync();

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

                conexion.ModificarFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text), TextBox1.Text, imagenoriginal, sonido);
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
                conexion.BorrarFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text));
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

        public static byte[] Convertir_Imagen_Bytes(System.Drawing.Image img)
        {


            string sTemp = Path.GetTempFileName();
            FileStream fs = new FileStream(sTemp, FileMode.OpenOrCreate, FileAccess.ReadWrite);
            img.Save(fs, System.Drawing.Imaging.ImageFormat.Png);
            fs.Position = 0;

            int imgLength = Convert.ToInt32(fs.Length);
            byte[] bytes = new byte[imgLength];
            fs.Read(bytes, 0, imgLength);
            fs.Close();
            return bytes;
        }
    }
}