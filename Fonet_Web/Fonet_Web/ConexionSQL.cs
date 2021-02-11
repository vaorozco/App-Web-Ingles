using Microsoft.SqlServer.Server;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI.WebControls;

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

        public string InsertarUsuario(string nombre, string apellido, string correo, string contraseña, int tipousuario)
        {
            string isTrue = "";
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarUsuario", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@apellido", apellido));
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                cmd.Parameters.Add(new SqlParameter("@tipousuario", tipousuario));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public void ModificarUsuario(int id, string nombre, string apellido, string correo, string contraseña, int tipousuario)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("ModificarUsuario", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@apellido", apellido));
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                cmd.Parameters.Add(new SqlParameter("@tipousuario", tipousuario));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public void BorrarUsuario(int id)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("BorrarUsuario", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public DataTable SeleccionarUsuario()
        {
            System.Data.DataTable table = new DataTable("ParentTable");
            // Declare variables for DataColumn and DataRow objects.
            DataColumn column;

            // Create new DataColumn, set DataType,
            // ColumnName and add to DataTable.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.Int32");
            column.ColumnName = "ID";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);


            column = new DataColumn();
            column.DataType = System.Type.GetType("System.Int32");
            column.ColumnName = "TIPO USUARIO";
            column.AutoIncrement = false;
            column.Caption = "TIPO USUARIO";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "NOMBRE";
            column.AutoIncrement = false;
            column.Caption = "NOMBRE";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "APELLIDO";
            column.AutoIncrement = false;
            column.Caption = "APELLIDO";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "CORREO";
            column.AutoIncrement = false;
            column.Caption = "CORREO";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "CONTRASEÑA";
            column.AutoIncrement = false;
            column.Caption = "CONTRASEÑA";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select * From Usuario";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString();
                    DataRow row = table.NewRow();
                    row["ID"] = myReader.GetValue(0).ToString();
                    row["TIPO USUARIO"] = myReader.GetValue(1);
                    row["NOMBRE"] = myReader.GetValue(2).ToString();
                    row["APELLIDO"] = myReader.GetValue(3).ToString();
                    row["CORREO"] = myReader.GetValue(4).ToString();
                    row["CONTRASEÑA"] = myReader.GetValue(5).ToString();
                    table.Rows.Add(row);
                }

                myReader.Close();
                conn.Close();
                return table;
            }
        }

        public DataTable SeleccionarFonema()
        {
            System.Data.DataTable table = new DataTable("ParentTable");
            // Declare variables for DataColumn and DataRow objects.
            DataColumn column;

            // Create new DataColumn, set DataType,
            // ColumnName and add to DataTable.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.Int32");
            column.ColumnName = "ID";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "FONEMA";
            column.AutoIncrement = false;
            column.Caption = "FONEMA";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select * From Fonema";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString();
                    DataRow row = table.NewRow();
                    row["ID"] = myReader.GetValue(0).ToString();
                    row["FONEMA"] = myReader.GetValue(1).ToString();
                    table.Rows.Add(row);
                }

                myReader.Close();
                conn.Close();
                return table;
            }
        }

        public string InsertarFonema(string nombre, byte[] imagen, byte[] sonido)
        {
            string isTrue = "";
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public void ModificarFonema(int id, string nombre, byte[] imagen, byte[] sonido)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("ModificarFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public void BorrarFonema(int id)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("BorrarFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public Fonema SeleccionarFonema(int id)
        {
            Fonema fonema = new Fonema();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("SeleccionarFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString()
                    fonema.nombre = myReader.GetValue(0).ToString();
                    //fonema.imagen = myReader.GetStream(1);
                    fonema.imagen = (byte[])myReader["imagen"];
                    fonema.sonido = (byte[])myReader["sonido"];
                }

                myReader.Close();
                conn.Close();
                return fonema;
            }
        }

        public Usuario SeleccionarUsuario(string correo, string contraseña)
        {
            Usuario usuario = new Usuario();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("SeleccionarUsuario", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    usuario.id = myReader.GetValue(0).ToString();
                    usuario.nombre = myReader.GetValue(1).ToString();
                    usuario.apellido = myReader.GetValue(2).ToString();
                    usuario.correo = myReader.GetValue(3).ToString();
                    usuario.contraseña = myReader.GetValue(4).ToString();
                    usuario.tipousuario = myReader.GetValue(5).ToString();
                }

                myReader.Close();
                conn.Close();
                return usuario;
            }
        }

        public List<ListItem> SeleccionarFonemas()
        {
            List<ListItem> lista = new List<ListItem>();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select IDFonema,nombre From Fonema";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString();
                    ListItem item = new ListItem(myReader.GetValue(1).ToString(), myReader.GetValue(0).ToString());
                    lista.Add(item);
                }

                myReader.Close();
                conn.Close();
                return lista;
            }
        }

        public List<Fonema> SeleccionarFonemas2()
        {
            List<Fonema> lista = new List<Fonema>();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select IDFonema,imagen,sonido From Fonema";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    Fonema fonema = new Fonema();
                    fonema.nombre = myReader.GetValue(0).ToString();
                    //fonema.imagen = myReader.GetStream(1);
                    fonema.imagen = (byte[])myReader["imagen"];
                    fonema.sonido = (byte[])myReader["sonido"];
                    lista.Add(fonema);
                }

                myReader.Close();
                conn.Close();
                return lista;
            }
        }

        public string login(string correo, string contraseña)
        {
            string isTrue = null;
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("loginCredenciales", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public string loginAdmin(string correo, string contraseña)
        {
            string isTrue = null;
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("loginAdmin", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                cmd.Parameters.Add(new SqlParameter("@contraseña", contraseña));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public RecuperarC recuperarContraseña(string correo)
        {
            RecuperarC recuperarc = new RecuperarC();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("recuperarContraseña", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@correo", correo));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    recuperarc.isTrue = rdr.GetValue(0).ToString();
                    recuperarc.nombre = rdr.GetValue(1).ToString() +" "+ rdr.GetValue(2).ToString();
                    recuperarc.contraseña = rdr.GetValue(3).ToString();
                }
                rdr.Close();
                conn.Close();
                return recuperarc;
            }
        }

        public DataTable SeleccionarPalabra()
        {
            System.Data.DataTable table = new DataTable("ParentTable");
            // Declare variables for DataColumn and DataRow objects.
            DataColumn column;

            // Create new DataColumn, set DataType,
            // ColumnName and add to DataTable.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.Int32");
            column.ColumnName = "ID";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "PALABRA";
            column.AutoIncrement = false;
            column.Caption = "PALABRA";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select * From Palabra";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString();
                    DataRow row = table.NewRow();
                    row["ID"] = myReader.GetValue(0).ToString();
                    row["PALABRA"] = myReader.GetValue(1).ToString();
                    table.Rows.Add(row);
                }

                myReader.Close();
                conn.Close();
                return table;
            }
        }

        public List<Palabra> SeleccionarPalabras(int idfonema)
        {
            List<Palabra> listapalabras = new List<Palabra>();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("SeleccionarPalabrasFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@idfonema", idfonema));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    Palabra palabra = SeleccionarPalabra(int.Parse(rdr.GetValue(0).ToString()));
                    listapalabras.Add(palabra);
                }
                rdr.Close();
                conn.Close();
                return listapalabras;
            }
        }

        public string InsertarPalabra(string nombre, byte[] imagen, byte[] sonido)
        {
            string isTrue = "";
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public void ModificarPalabra(int id, string nombre, byte[] imagen, byte[] sonido)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("ModificarPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public void ModificarFonemaPalabra(int idpalabra, int idfonema)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("ModificarFonemaPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@idpalabra", idpalabra));
                cmd.Parameters.Add(new SqlParameter("@idfonema", idfonema));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public void BorrarPalabra(int id)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("BorrarPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public void BorrarPalabraFonema(int id)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("BorrarPalabraFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@idpalabra", id));
                SqlDataReader rdr = cmd.ExecuteReader();
            }
        }

        public Palabra SeleccionarPalabra(int id)
        {
            Palabra palabra = new Palabra();
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("SeleccionarPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@id", id));
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    // Assuming your desired value is the name as the 3rd field
                    //Usuarios = myReader.GetValues(2).ToString()
                    palabra.nombre = myReader.GetValue(0).ToString();
                    palabra.imagen = (byte[])myReader["imagen"];
                    palabra.sonido = (byte[])myReader["sonido"];
                }

                myReader.Close();
                conn.Close();
                return palabra;
            }
        }

        public String SeleccionarFonemaPalabra(int id)
        {
            String IDFonema = "";
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("SeleccionarFonemaPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@idpalabra", id));
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    IDFonema = myReader.GetValue(0).ToString();
                }

                myReader.Close();
                conn.Close();
                return IDFonema;
            }
        }

        public string InsertarPalabraXFonema(int idfonema,string idpalabra)
        {
            string isTrue = "";
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarPalabraXFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@idfonema", idfonema));
                cmd.Parameters.Add(new SqlParameter("@palabra", idpalabra));
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    isTrue = rdr.GetValue(0).ToString();
                }
                rdr.Close();
                conn.Close();
                return isTrue;
            }
        }

        public int ContarPalabras()
        {
            int cantidad = 0;
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select count(IDPalabra) From Palabra";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    cantidad = int.Parse(myReader.GetValue(0).ToString());
                }

                myReader.Close();
                conn.Close();
                return cantidad;
            }
        }

        public int ContarFonemas()
        {
            int cantidad = 0;
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                string strSelect = "Select count(IDFonema) From Fonema";
                SqlCommand cmd = new SqlCommand(strSelect, conn);
                SqlDataReader myReader = cmd.ExecuteReader();
                while (myReader.Read())
                {
                    cantidad = int.Parse(myReader.GetValue(0).ToString());
                }

                myReader.Close();
                conn.Close();
                return cantidad;
            }
        }
    }
}