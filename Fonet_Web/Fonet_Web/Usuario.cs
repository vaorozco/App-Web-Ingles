using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class Usuario
    {

        public string nombre { get; set; }
        public string apellido { get; set; }
        public string correo { get; set; }
        public string contraseña { get; set; }
        public string tipousuario { get; set; }

        public Usuario(string nombre, string apellido, string correo, string contraseña, string tipousuario)
        {
            this.nombre = nombre;
            this.apellido = apellido;
            this.correo = correo;
            this.contraseña = contraseña;
            this.tipousuario = tipousuario;
        }

        public Usuario()
        {
        }
    }
}