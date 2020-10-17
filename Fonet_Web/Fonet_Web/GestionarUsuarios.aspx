<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarUsuarios.aspx.cs" Inherits="Fonet_Web.GestionarUsuarios" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="33px" style="background-color: #006600">
            <asp:Label ID="Label5" runat="server" style="top: 278px; left: 805px; position: absolute; height: 19px; width: 34px" Text="Contraseña:"></asp:Label>
            <asp:Label ID="Label4" runat="server" Text="Correo:" style="top: 228px; left: 806px; position: absolute; height: 19px; width: 34px"></asp:Label>
        </asp:Panel>
        <asp:TextBox ID="TextBox1" runat="server" style="top: 126px; left: 924px; position: absolute; height: 22px; width: 419px"></asp:TextBox>
        <asp:TextBox ID="TextBox2" runat="server" style="top: 173px; left: 923px; position: absolute; height: 18px; width: 419px"></asp:TextBox>
        <asp:TextBox ID="TextBox3" runat="server" style="top: 224px; left: 922px; position: absolute; height: 22px; width: 422px; right: 170px"></asp:TextBox>
        <asp:TextBox ID="TextBox4" runat="server" style="top: 271px; left: 921px; position: absolute; height: 22px; width: 421px"></asp:TextBox>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 366px; left: 1290px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 366px; left: 1200px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" OnClick="ImageButton2_Click" />
        <asp:DropDownList ID="DropDownList1" runat="server" style="top: 318px; left: 1196px; position: absolute; height: 22px; width: 152px">
            <asp:ListItem Value="1">Administrador</asp:ListItem>
            <asp:ListItem Value="2">Estudiante</asp:ListItem>
        </asp:DropDownList>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 550px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
        <asp:Label ID="Label1" runat="server" style="top: 95px; left: 808px; position: absolute; height: 19px; width: 34px" Text="Usuario"></asp:Label>
        <asp:Label ID="Label2" runat="server" style="top: 132px; left: 803px; position: absolute; height: 19px; width: 34px" Text="Nombre:"></asp:Label>
        <asp:Label ID="Label3" runat="server" style="top: 177px; left: 807px; position: absolute; height: 19px; width: 34px" Text="Apellido:"></asp:Label>
        <asp:Label ID="Label6" runat="server" style="left: 808px; position: absolute; height: 19px; width: 34px; top: 319px" Text="Tipo:"></asp:Label>
        <p style="height: 2px">
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 365px; left: 1105px; position: absolute; right: 353px;" Width="56px" ImageUrl="~/Recursos/cerrar.png" OnClick="ImageButton3_Click" />
        </p>
    </form>
</body>
</html>
