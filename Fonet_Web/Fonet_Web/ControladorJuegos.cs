using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class ControladorJuegos
    {
        private static ControladorJuegos _instance = new ControladorJuegos();
        public List<Palabra> palabras { get; set; }
        public List<Palabra> palabrasrevueltas { get; set; }
        public Palabra palabraS1 { get; set; }
        public Palabra palabraS2 { get; set; }

        public Palabra palabra { get; set; }
        public List<string> palabrasf { get; set; }


        private ControladorJuegos()
        {
            palabraS1 = null;
            palabraS2 = null;
        }

        public static ControladorJuegos Instance
        {
            get
            {
                return _instance;
            }
        }
    }
}