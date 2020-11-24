using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class ControladorGeneral
    {
        private static ControladorGeneral _instance = new ControladorGeneral();
        public Usuario usuario { get; set; }

        private ControladorGeneral()
        {
        }

        public static ControladorGeneral Instance
        {
            get
            {
                return _instance;
            }
        }
    }
}