using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading;
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
            ControladorJuegos.Instance.palabras = new List<Palabra>();
            ControladorJuegos.Instance.palabrasrevueltas = new List<Palabra>();
            activar();

            ConexionSQL conexion = new ConexionSQL();
            int maximo = conexion.ContarPalabras();
            string folderPath = Server.MapPath("~/Recursos/");
            List<int> listaids = Generar_LRandom(maximo);
            for (int i = 0; i < listaids.Count; i++)
            {
                Palabra palabra = conexion.SeleccionarPalabra(listaids[i]);
                ControladorJuegos.Instance.palabras.Add(palabra);
                System.Drawing.Image imagen2 = byteArrayToImage(palabra.imagen);
                imagen2.Save(folderPath + palabra.nombre + ".png");
            }
            ControladorJuegos.Instance.palabrasrevueltas = ControladorJuegos.Instance.palabras.OrderBy(a => Guid.NewGuid()).ToList();
            ib1.ImageUrl = "~/Recursos/" + ControladorJuegos.Instance.palabras[0].nombre + ".png";
            ib2.ImageUrl = "~/Recursos/" + ControladorJuegos.Instance.palabras[1].nombre + ".png";
            ib3.ImageUrl = "~/Recursos/" + ControladorJuegos.Instance.palabras[2].nombre + ".png";
            ib4.ImageUrl = "~/Recursos/" + ControladorJuegos.Instance.palabras[3].nombre + ".png";
            ib5.ImageUrl = "~/Recursos/" + ControladorJuegos.Instance.palabras[4].nombre + ".png";
            b1.Text = ControladorJuegos.Instance.palabrasrevueltas[0].nombre;
            b2.Text = ControladorJuegos.Instance.palabrasrevueltas[1].nombre;
            b3.Text = ControladorJuegos.Instance.palabrasrevueltas[2].nombre;
            b4.Text = ControladorJuegos.Instance.palabrasrevueltas[3].nombre;
            b5.Text = ControladorJuegos.Instance.palabrasrevueltas[4].nombre;
        }

        public void activar()
        {
            ib1.Visible = true;
            ib2.Visible = true;
            ib3.Visible = true;
            ib4.Visible = true;
            ib5.Visible = true;
            b1.Visible = true;
            b2.Visible = true;
            b3.Visible = true;
            b4.Visible = true;
            b5.Visible = true;
        }

        protected void ib1_Click(object sender, ImageClickEventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabras[0];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabras[0];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    ib1.Visible = false;
                    string id = "";
                    for(int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabras[0])
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    botonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void ib2_Click(object sender, ImageClickEventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabras[1];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabras[1];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    ib2.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabras[1])
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    botonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void ib3_Click(object sender, ImageClickEventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabras[2];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabras[2];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    ib3.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabras[2])
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    botonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void ib4_Click(object sender, ImageClickEventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabras[3];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabras[3];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    ib4.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabras[3])
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    botonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void ib5_Click(object sender, ImageClickEventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabras[4];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabras[4];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    ib5.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabras[4])
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    botonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabrasrevueltas.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabrasrevueltas[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "b" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void b1_Click(object sender, EventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabrasrevueltas[0];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabrasrevueltas[0];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    b1.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabrasrevueltas[0])
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    imagenbotonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void b2_Click(object sender, EventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabrasrevueltas[1];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabrasrevueltas[1];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    b2.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabrasrevueltas[1])
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    imagenbotonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void b3_Click(object sender, EventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabrasrevueltas[2];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabrasrevueltas[2];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    b3.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabrasrevueltas[2])
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    imagenbotonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void b4_Click(object sender, EventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabrasrevueltas[3];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabrasrevueltas[3];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    b4.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabrasrevueltas[3])
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    imagenbotonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        protected void b5_Click(object sender, EventArgs e)
        {
            if (ControladorJuegos.Instance.palabraS1 == null)
            {
                ControladorJuegos.Instance.palabraS1 = ControladorJuegos.Instance.palabrasrevueltas[4];
            }
            else
            {
                ControladorJuegos.Instance.palabraS2 = ControladorJuegos.Instance.palabrasrevueltas[4];
                if (ControladorJuegos.Instance.palabraS1 == ControladorJuegos.Instance.palabraS2)
                {
                    b5.Visible = false;
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabrasrevueltas[4])
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    imagenbotonvisiblefalse(id);
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
                else
                {
                    string id = "";
                    for (int i = 0; i < ControladorJuegos.Instance.palabras.Count; i++)
                    {
                        if (ControladorJuegos.Instance.palabras[i] == ControladorJuegos.Instance.palabraS1)
                        {
                            int i2 = i + 1;
                            id = "ib" + i2.ToString();
                        }
                    }
                    ControladorJuegos.Instance.palabraS1 = null;
                    ControladorJuegos.Instance.palabraS2 = null;
                }
            }
        }

        public void botonvisiblefalse(string id)
        {
            foreach (Control componente in form1.Controls)
            {
                if (componente is Button)
                {
                    if (componente.ID == id)
                    {
                        componente.Visible = false;
                    }
                }
            }
        }

        public void imagenbotonvisiblefalse(string id)
        {
            foreach (Control componente in form1.Controls)
            {
                if (componente is ImageButton)
                {
                    if (componente.ID == id)
                    {
                        componente.Visible = false;
                    }
                }
            }
        }
    }
}