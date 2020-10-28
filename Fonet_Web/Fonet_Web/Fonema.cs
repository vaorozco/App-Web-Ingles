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
        public byte[] imagen { get; set; }
        public byte[] sonido { get; set; }

        public Fonema(string nombre, byte[] imagen, byte[] sonido)
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