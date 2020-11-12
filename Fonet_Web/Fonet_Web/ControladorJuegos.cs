using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class ControladorJuegos
    {
        private static ControladorJuegos _instance = new ControladorJuegos();
        public string nombre1 { get; set; }
        public string nombre2 { get; set; }


        private ControladorJuegos()
        {
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