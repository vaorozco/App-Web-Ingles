<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarUsuarios.aspx.cs" Inherits="Fonet_Web.GestionarUsuarios" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 209px;
            position: absolute;
            left: 780px;
            top: 141px;
            width: 39%;
        }
        .auto-style3 {
            width: 100px;
        }
        .auto-style4 {
            width: 457px;
        }
        .auto-style5 {
            margin-left: 0px;
        }
        .auto-style6 {
            top: 106px;
            left: 781px;
            position: absolute;
            height: 19px;
            width: 34px;
        }
    </style>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="33px" style="background-color: #006600">
        </asp:Panel>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 366px; left: 1290px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 366px; left: 1200px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" OnClick="ImageButton2_Click" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 550px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
        <asp:Label ID="Label1" runat="server" Text="Usuario" CssClass="auto-style6"></asp:Label>
        <p style="height: 2px">
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 365px; left: 1105px; position: absolute; right: 353px;" Width="56px" ImageUrl="~/Recursos/cerrar.png" OnClick="ImageButton3_Click" />
        </p>
        <table class="auto-style1">
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label2" runat="server" Text="Nombre:"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox1" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label3" runat="server" Text="Apellido:"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox2" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label4" runat="server" Text="Correo"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox3" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label5" runat="server" Text="Contraseña:"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox4" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label6" runat="server" Text="Tipo"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:DropDownList ID="DropDownList1" runat="server" CssClass="auto-style5" Height="16px" Width="128px">
                        <asp:ListItem Value="0">Administrador</asp:ListItem>
                        <asp:ListItem Value="1">Estudiante</asp:ListItem>
                    </asp:DropDownList>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
