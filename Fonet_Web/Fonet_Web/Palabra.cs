using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class Palabra
    {
        public string nombre { get; set; }

        public string fonema { get; set; }

        public byte[] imagen { get; set; }
        public byte[] sonido { get; set; }

        public Palabra(string nombre, string fonema, byte[] imagen, byte[] sonido)
        {
            this.nombre = nombre;
            this.fonema = fonema;
            this.imagen = imagen;
            this.sonido = sonido;
        }

        public Palabra()
        {
        }
    }
}