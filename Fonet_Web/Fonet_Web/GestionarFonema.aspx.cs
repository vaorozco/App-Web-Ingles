using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class GestionarFonema: System.Web.UI.Page
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

        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            TextBox1.Text = GridView1.SelectedRow.Cells[3].Text;
        }

        protected void ImageButton4_Click(object sender, ImageClickEventArgs e)
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

        protected void ImageButton5_Click(object sender, ImageClickEventArgs e)
        {
            string pathToFiles = Server.MapPath("../Recursos/correct.wav");
            System.Media.SoundPlayer player = new System.Media.SoundPlayer(pathToFiles);
            player.Play();
        }
    }
}