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
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
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
            byte[] sonido = ControladorUI.Instance.get_sonido();
            byte[] imagen = ControladorUI.Instance.get_imagen();
            try
            {
                string isTrue = conexion.InsertarFonema(TextBox1.Text, imagen, sonido);
                if (isTrue == "0")
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "alertIns", "alert('El fonema no se guardó ya existe');", true);
                }
                else
                {
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Registro el Fonema'); window.location='" + Request.ApplicationPath + "GestionarFonema.aspx';", true);
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
                Fonema fonema = new Fonema();
                fonema = conexion.SeleccionarFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text));
                ControladorUI.Instance.set_sonido(fonema.sonido);
                ControladorUI.Instance.set_imagen(fonema.imagen);
                TextBox1.Text = fonema.nombre;
                System.Drawing.Image imagen = byteArrayToImage(fonema.imagen);
                string folderPath = Server.MapPath("~/Recursos/");
                imagen.Save(folderPath + fonema.nombre + ".png");
                File.WriteAllBytes(folderPath + fonema.nombre + ".wav", fonema.sonido);
                Label1.Text = folderPath + fonema.nombre + ".wav";
                Label5.Text = fonema.nombre + ".wav";
                Image1.ImageUrl = "~/Recursos/"+ fonema.nombre + ".png";
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
                if (!Directory.Exists(folderPath))
                {
                    Directory.CreateDirectory(folderPath);
                }
                FileUpload1.SaveAs(folderPath + Path.GetFileName(FileUpload1.FileName));
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
                /*byte[] sonido;
                BinaryReader br = new BinaryReader(FileUpload2.PostedFile.InputStream);
                sonido = br.ReadBytes((int)FileUpload2.PostedFile.InputStream.Length);*/

                /*int tamaño = FileUpload1.PostedFile.ContentLength;
                byte[] imagenoriginal = new byte[tamaño];
                FileUpload1.PostedFile.InputStream.Read(imagenoriginal, 0, tamaño);
                Bitmap ImagenOriginalBinaria = new Bitmap(FileUpload1.PostedFile.InputStream);*/

                byte[] imagen = ControladorUI.Instance.get_imagen();

                conexion.ModificarFonema(int.Parse(GridView1.SelectedRow.Cells[1].Text), TextBox1.Text, imagen, sonido);
                //Page.Response.Redirect(Page.Request.Url.ToString(), true);
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Modifico el Fonema'); window.location='" + Request.ApplicationPath + "GestionarFonema.aspx';", true);
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
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Se Elimino el Fonema'); window.location='" + Request.ApplicationPath + "GestionarFonema.aspx';", true);
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

        public System.Drawing.Image byteArrayToImage(byte[] bytesArr)
        {
            using (MemoryStream memstr = new MemoryStream(bytesArr))
            {
                System.Drawing.Image img = System.Drawing.Image.FromStream(memstr);
                return img;
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