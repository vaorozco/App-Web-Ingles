<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarFonema.aspx.cs" Inherits="Fonet_Web.GestionarFonema" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="33px" style="background-color: #006600">
        </asp:Panel>
        <asp:TextBox ID="TextBox1" runat="server" style="top: 131px; left: 930px; position: absolute; height: 22px; width: 540px"></asp:TextBox>
        <asp:TextBox ID="TextBox2" runat="server" style="top: 180px; left: 932px; position: absolute; height: 18px; width: 537px"></asp:TextBox>
        <asp:TextBox ID="TextBox3" runat="server" style="top: 226px; left: 932px; position: absolute; height: 22px; width: 536px; right: 27px"></asp:TextBox>
        <asp:TextBox ID="TextBox4" runat="server" style="top: 272px; left: 933px; position: absolute; height: 22px; width: 533px"></asp:TextBox>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 348px; left: 1423px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 350px; left: 1308px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 348px; left: 1179px; position: absolute" Width="56px" ImageUrl="~/Recursos/cerrar.png" />
        <asp:DropDownList ID="DropDownList1" runat="server" style="top: 317px; left: 1322px; position: absolute; height: 22px; width: 152px">
            <asp:ListItem Value="1">Administrador</asp:ListItem>
            <asp:ListItem Value="2">Estudiante</asp:ListItem>
        </asp:DropDownList>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 621px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
    </form>
</body>
</html>
