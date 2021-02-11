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
    public partial class Pareo2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (ControladorGeneral.Instance.usuario.tipousuario == "2")
            {
                ImageButton11.Visible = false;
            }
            Label1.Text = ControladorGeneral.Instance.usuario.nombre + " " + ControladorGeneral.Instance.usuario.apellido;
        }

        protected void Altavoz_Click(object sender, ImageClickEventArgs e)
        {
            try
            {
                SoundPlayer _sm = new SoundPlayer();
                string folderPath = Server.MapPath("~/Recursos/");
                if (ControladorJuegos.Instance.palabra != null)
                {
                    _sm.SoundLocation = folderPath + ControladorJuegos.Instance.palabra.nombre + ".wav";
                    _sm.PlaySync();
                }
            }
            catch
            {
                Console.WriteLine("No se puede");
            }
        }

        protected void Revisar_Click(object sender, EventArgs e)
        {

        }

        public List<int> Generar_LRandom(int maximo)
        {
            List<int> lrandom = new List<int>();
            while (lrandom.Count < 3)
            {
                //Recuperamos un número aleatorio entre 10000 y 100000
                int numeroAleatorio = new Random().Next(1, maximo);

                //Sólo si el número generado no existe en lalista se agrega
                if (!lrandom.Contains(numeroAleatorio))
                {
                    lrandom.Add(numeroAleatorio);
                }
            }
            return lrandom;
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

        protected void Cargar_Click(object sender, EventArgs e)
        {
            ControladorJuegos.Instance.palabra = new Palabra();
            ControladorJuegos.Instance.palabrasf = new List<string>();
            Palabra1.ForeColor = System.Drawing.Color.Black;
            Palabra2.ForeColor = System.Drawing.Color.Black;
            Palabra3.ForeColor = System.Drawing.Color.Black;
            ConexionSQL conexion = new ConexionSQL();
            int maximo = conexion.ContarPalabras();
            string folderPath = Server.MapPath("~/Recursos/");
            List<int> listaids = Generar_LRandom(maximo);
            ControladorJuegos.Instance.palabra = conexion.SeleccionarPalabra(listaids[0]);
            File.WriteAllBytes(folderPath + ControladorJuegos.Instance.palabra.nombre + ".wav", ControladorJuegos.Instance.palabra.sonido);
            string palabrareal = ControladorJuegos.Instance.palabra.nombre;
            string palabrafalsa1 = conexion.SeleccionarPalabra(listaids[1]).nombre;
            string palabrafalsa2 = conexion.SeleccionarPalabra(listaids[2]).nombre;
            ControladorJuegos.Instance.palabrasf.Add(palabrafalsa1);
            ControladorJuegos.Instance.palabrasf.Add(palabrafalsa2);
            ControladorJuegos.Instance.palabrasf.Add(palabrareal);
            ControladorJuegos.Instance.palabrasf = ControladorJuegos.Instance.palabrasf.OrderBy(a => Guid.NewGuid()).ToList();

            Palabra1.Text = ControladorJuegos.Instance.palabrasf[0];
            Palabra2.Text = ControladorJuegos.Instance.palabrasf[1];
            Palabra3.Text = ControladorJuegos.Instance.palabrasf[2];
        }

        protected void Palabra1_Click(object sender, EventArgs e)
        {
            if(Palabra1.Text== ControladorJuegos.Instance.palabra.nombre)
            {
                Palabra1.ForeColor = System.Drawing.Color.Green;
                ControladorJuegos.Instance.palabra = null;
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Palabra Correcta'); window.location='" + Request.ApplicationPath + "Pareo2.aspx';", true);
            }
            else
            {
                Palabra1.ForeColor = System.Drawing.Color.Red;
            }
        }

        protected void Palabra2_Click(object sender, EventArgs e)
        {
            if (Palabra2.Text == ControladorJuegos.Instance.palabra.nombre)
            {
                Palabra2.ForeColor = System.Drawing.Color.Green;
                ControladorJuegos.Instance.palabra = null;
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Palabra Correcta'); window.location='" + Request.ApplicationPath + "Pareo2.aspx';", true);
            }
            else
            {
                Palabra2.ForeColor = System.Drawing.Color.Red;
            }
        }

        protected void Palabra3_Click(object sender, EventArgs e)
        {
            if (Palabra3.Text == ControladorJuegos.Instance.palabra.nombre)
            {
                Palabra3.ForeColor = System.Drawing.Color.Green;
                ControladorJuegos.Instance.palabra = null;
                ScriptManager.RegisterStartupScript(this, this.GetType(), "redirect", "alert('Palabra Correcta'); window.location='" + Request.ApplicationPath + "Pareo2.aspx';", true);
            }
            else
            {
                Palabra3.ForeColor = System.Drawing.Color.Red;
            }
        }
    }
}