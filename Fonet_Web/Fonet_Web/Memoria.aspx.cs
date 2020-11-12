using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class Memoria : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
           
        }

        public List<int> Generar_LRandom(int maximo)
        {
            List<int> lrandom = new List<int>();
            while (lrandom.Count < 5)
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

        }

        protected void ImageButton9_Click(object sender, ImageClickEventArgs e)
        {

        }

        protected void ImageButton10_Click(object sender, ImageClickEventArgs e)
        {

        }

        protected void ImageButton12_Click(object sender, ImageClickEventArgs e)
        {

        }

        protected void Button2_Click(object sender, EventArgs e)
        {

        }

        public System.Drawing.Image byteArrayToImage(byte[] bytesArr)
        {
            using (MemoryStream memstr = new MemoryStream(bytesArr))
            {
                System.Drawing.Image img = System.Drawing.Image.FromStream(memstr);
                return img;
            }
        }

        protected void Comenzar_Click(object sender, EventArgs e)
        {
            ConexionSQL conexion = new ConexionSQL();
            int maximo = conexion.ContarPalabras();
            string folderPath = Server.MapPath("~/Recursos/");
            List<int> listaids = Generar_LRandom(maximo);
            List<Palabra> palabras = new List<Palabra>();
            for (int i = 0; i < listaids.Count; i++)
            {
                Palabra palabra = conexion.SeleccionarPalabra(listaids[i]);
                palabras.Add(palabra);
                System.Drawing.Image imagen2 = byteArrayToImage(palabra.imagen);
                imagen2.Save(folderPath + palabra.nombre + ".png");
            }

            Button3.Text = palabras[0].nombre;
            Button4.Text = palabras[1].nombre;
            Button5.Text = palabras[2].nombre;
            Button6.Text = palabras[3].nombre;
            Button7.Text = palabras[4].nombre;

            Button3.ID = "nombre" + palabras[0].nombre;
            Button4.ID = "nombre" + palabras[1].nombre;
            Button5.ID = "nombre" + palabras[2].nombre;
            Button6.ID = "nombre" + palabras[3].nombre;
            Button7.ID = "nombre" + palabras[4].nombre;

            List<Palabra> palabrasOrdenadas = (List<Palabra>)palabras.OrderBy(x => x.nombre).ToList();

            ImageButton13.ImageUrl = "~/Recursos/" + palabrasOrdenadas[0].nombre + ".png";
            ImageButton16.ImageUrl = "~/Recursos/" + palabrasOrdenadas[1].nombre + ".png";
            ImageButton17.ImageUrl = "~/Recursos/" + palabrasOrdenadas[2].nombre + ".png";
            ImageButton20.ImageUrl = "~/Recursos/" + palabrasOrdenadas[3].nombre + ".png";
            ImageButton21.ImageUrl = "~/Recursos/" + palabrasOrdenadas[4].nombre + ".png";

            ImageButton13.ID = "imagen" + palabrasOrdenadas[0].nombre;
            ImageButton16.ID = "imagen" + palabrasOrdenadas[1].nombre;
            ImageButton17.ID = "imagen" + palabrasOrdenadas[2].nombre;
            ImageButton20.ID = "imagen" + palabrasOrdenadas[3].nombre;
            ImageButton21.ID = "imagen" + palabrasOrdenadas[4].nombre;

            activar();
        }

        public void activar()
        {
            Button3.Visible = true;
            Button4.Visible = true;
            Button5.Visible = true;
            Button6.Visible = true;
            Button7.Visible = true;
            ImageButton13.Visible = true;
            ImageButton16.Visible = true;
            ImageButton17.Visible = true;
            ImageButton20.Visible = true;
            ImageButton21.Visible = true;
        }

        protected void EncontrarPareja(object sender, ImageClickEventArgs e)
        {
            ImageButton button = (ImageButton)sender;
            if (ControladorJuegos.Instance.nombre1 == "")
            {
                ControladorJuegos.Instance.nombre1 = button.ID.Substring(6);
            }
            else 
            {
                ControladorJuegos.Instance.nombre2 = button.ID.Substring(6);
            }

            if(ControladorJuegos.Instance.nombre1 == ControladorJuegos.Instance.nombre2)
            {
                foreach (var textBox in this.form1.Controls.OfType<Button>())
                {
                    if (textBox.ID == ControladorJuegos.Instance.nombre1 || textBox.ID == ControladorJuegos.Instance.nombre2)
                    {
                        textBox.Visible = false;
                    }
                }

                foreach (var textBox in this.form1.Controls.OfType<ImageButton>())
                {
                    if (textBox.ID == ControladorJuegos.Instance.nombre1 || textBox.ID == ControladorJuegos.Instance.nombre2)
                    {
                        textBox.Visible = false;
                    }
                }
            }
        }

        protected void EncontrarPareja2(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            if (ControladorJuegos.Instance.nombre1 == "")
            {
                ControladorJuegos.Instance.nombre1 = button.ID.Substring(6);
            }
            else
            {
                ControladorJuegos.Instance.nombre2 = button.ID.Substring(6);
            }

            if (ControladorJuegos.Instance.nombre1 == ControladorJuegos.Instance.nombre2)
            {
                foreach (var textBox in this.form1.Controls.OfType<Button>())
                {
                    if (textBox.ID == ControladorJuegos.Instance.nombre1 || textBox.ID == ControladorJuegos.Instance.nombre2)
                    {
                        textBox.Visible = false;
                    }
                }

                foreach (var textBox in this.form1.Controls.OfType<ImageButton>())
                {
                    if (textBox.ID == ControladorJuegos.Instance.nombre1 || textBox.ID == ControladorJuegos.Instance.nombre2)
                    {
                        textBox.Visible = false;
                    }
                }
            }
        }
    }
}