using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public class ConexionSQL
    {
        //public string conexion = "Server=(local);DataBase=AnalisisdeRostros;Integrated Security=SSPI";
        //public string conexion2 = "Server=(local);DataBase=AnalisisdeRostros2;Integrated Security=SSPI";
        public string conexion = "Server=tcp:fonet.database.windows.net,1433;Initial Catalog=proyecto_fonet;Persist Security Info=False;User ID=avalverder;Password=c3rv@nt3s;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public ConexionSQL()
        {
        }

        public void InsertarUSuario(string nombre, string apellido, string correo, string contraseña)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarUsuario", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@apellido", apellido));
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }
    }
}