using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class Fonema
    {
        public string nombre { get; set; }
        public Stream imagen { get; set; }
        public Stream sonido { get; set; }

        public Fonema(string nombre, Stream imagen, Stream sonido)
        {
            this.nombre = nombre;
            this.imagen = imagen;
            this.sonido = sonido;
        }

        public Fonema()
        {
        }
    }
}