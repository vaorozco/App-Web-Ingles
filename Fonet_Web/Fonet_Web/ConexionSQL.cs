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

        public void InsertarUsuario(string nombre, string apellido, string correo, string contraseña, int tipousuario)
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
                cmd.Parameters.Add(new SqlParameter("@tipousuario", tipousuario));
                SqlDataReader rdr = cmd.ExecuteReader();
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
            column.ColumnName = "id";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);


            column = new DataColumn();
            column.DataType = System.Type.GetType("System.Int32");
            column.ColumnName = "Tipo Usuario";
            column.AutoIncrement = false;
            column.Caption = "Tipo Usuario";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Nombre";
            column.AutoIncrement = false;
            column.Caption = "Nombre";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Apellido";
            column.AutoIncrement = false;
            column.Caption = "Apellido";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Correo";
            column.AutoIncrement = false;
            column.Caption = "Correo";
            column.ReadOnly = false;
            column.Unique = false;
            // Add the column to the table.
            table.Columns.Add(column);

            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Contraseña";
            column.AutoIncrement = false;
            column.Caption = "Contraseña";
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
                    row["id"] = myReader.GetValue(0).ToString();
                    row["Tipo Usuario"] = myReader.GetValue(1);
                    row["Nombre"] = myReader.GetValue(2).ToString();
                    row["Apellido"] = myReader.GetValue(3).ToString();
                    row["Correo"] = myReader.GetValue(4).ToString();
                    row["Contraseña"] = myReader.GetValue(5).ToString();
                    Console.WriteLine(myReader.GetValue(0).ToString());
                    Console.WriteLine(myReader.GetValue(1).ToString());
                    Console.WriteLine(myReader.GetValue(2).ToString());
                    Console.WriteLine(myReader.GetValue(3).ToString());
                    Console.WriteLine(myReader.GetValue(4).ToString());
                    Console.WriteLine(myReader.GetValue(4).ToString());
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
            column.ColumnName = "id";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Fonema";
            column.AutoIncrement = false;
            column.Caption = "Fonema";
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
                    row["Fonema"] = myReader.GetValue(1).ToString();
                    table.Rows.Add(row);
                }

                myReader.Close();
                conn.Close();
                return table;
            }
        }

        public void InsertarFonema(string nombre, byte[] imagen, byte[] sonido)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarFonema", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
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
                    fonema.imagen = myReader.GetStream(1);
                    fonema.sonido = (byte[])myReader["sonido"];
                }

                myReader.Close();
                conn.Close();
                return fonema;
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
            column.ColumnName = "id";
            column.ReadOnly = true;
            column.Unique = true;
            // Add the Column to the DataColumnCollection.
            table.Columns.Add(column);

            // Create second column.
            column = new DataColumn();
            column.DataType = System.Type.GetType("System.String");
            column.ColumnName = "Palabra";
            column.AutoIncrement = false;
            column.Caption = "Palabra";
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
                    row["Palabra"] = myReader.GetValue(1).ToString();
                    table.Rows.Add(row);
                }

                myReader.Close();
                conn.Close();
                return table;
            }
        }

        public void InsertarPalabra(string nombre, byte[] imagen, byte[] sonido)
        {
            using (SqlConnection conn = new SqlConnection(conexion))
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("InsertarPalabra", conn);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.Add(new SqlParameter("@nombre", nombre));
                cmd.Parameters.Add(new SqlParameter("@imagen", imagen));
                cmd.Parameters.Add(new SqlParameter("@sonido", sonido));
                SqlDataReader rdr = cmd.ExecuteReader();
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
                    palabra.imagen = myReader.GetStream(1);
                    palabra.sonido = (byte[])myReader["sonido"];
                }

                myReader.Close();
                conn.Close();
                return palabra;
            }
        }
    }
}