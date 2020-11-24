<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Memoria.aspx.cs" Inherits="Fonet_Web.Memoria" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style5 {
            width: 26%;
            height: 32px;
            position: absolute;
            left: 526px;
            top: 16px;
        }
        .auto-style6 {
            width: 71px;
        }
        .auto-style7 {
            height: 23px;
        }
        .auto-style8 {
            height: 31px;
            position: absolute;
            left: 1016px;
            top: 18px;
            width: 26%;
        }
        .auto-style9 {
            height: 23px;
            width: 228px;
        }
        .auto-style12 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 46px;
            top: 75px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
        }
        .auto-style13 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
            background-color: #006600;
        }
        .auto-style14 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
        }
        .auto-style15 {
            width: 91%;
            height: 404px;
            position: absolute;
            left: 62px;
            top: 166px;
        }
        .auto-style17 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: x-large;
            background-color: #FFFFFF;
        }
        .auto-style18 {
            width: 94px;
            height: 26px;
            position: absolute;
            left: 1210px;
            top: 599px;
            color: #FFFFFF;
            font-family: Arial, Helvetica, sans-serif;
            font-size: medium;
            background-color: #009900;
        }
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
                <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
                <table class="auto-style5">
                    <tr>
                        <td class="auto-style6">
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="30px" ImageUrl="~/Recursos/menuicon.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton9" runat="server" Height="30px" ImageUrl="~/Recursos/gamepad.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" OnClick="ImageButton10_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton11" runat="server" Height="30px" ImageUrl="~/Recursos/ajustes.png" Width="30px" OnClick="ImageButton11_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton12" runat="server" Height="30px" ImageUrl="~/Recursos/usuario.png" Width="30px" />
                        </td>
                    </tr>
                </table>
            </asp:Panel>
        </div>
        <p>
            <table class="auto-style8">
                <tr>
                    <td class="auto-style9">
                        <asp:Label ID="Label1" runat="server" Text="Label" CssClass="auto-style14"></asp:Label>
                    </td>
                    <td class="auto-style7">
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Memoria"></asp:Label>
        </p>
        <table class="auto-style15" id="Tabla1">
            <tr>
                <td>
                    <asp:ImageButton ID="ib1" runat="server" Height="200px" OnClick="ib1_Click" Width="200px" ImageUrl="~/Recursos/Icono Memoria.png" />
                </td>
                <td>
                    <asp:Button ID="b2" runat="server" CssClass="auto-style17" Height="200px" OnClick="b2_Click" Width="200px" Text="Memoria" />
                </td>
                <td>
                    <asp:ImageButton ID="ib3" runat="server" Height="200px" OnClick="ib3_Click" Width="200px" ImageUrl="~/Recursos/Icono Memoria.png" />
                </td>
                <td>
                    <asp:Button ID="b4" runat="server" CssClass="auto-style17" Height="200px" OnClick="b4_Click" Width="200px" Text="Memoria" />
                </td>
                <td>
                    <asp:ImageButton ID="ib5" runat="server" Height="200px" OnClick="ib5_Click" Width="200px" ImageUrl="~/Recursos/Icono Memoria.png" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Button ID="b1" runat="server" CssClass="auto-style17" Height="200px" OnClick="b1_Click" Width="200px" Text="Memoria" />
                </td>
                <td>
                    <asp:ImageButton ID="ib2" runat="server" Height="200px" OnClick="ib2_Click" Width="200px" ImageUrl="~/Recursos/Icono Memoria.png" />
                </td>
                <td>
                    <asp:Button ID="b3" runat="server" CssClass="auto-style17" Height="200px" OnClick="b3_Click" Width="200px" Text="Memoria" />
                </td>
                <td>
                    <asp:ImageButton ID="ib4" runat="server" Height="200px" OnClick="ib4_Click" Width="200px" ImageUrl="~/Recursos/Icono Memoria.png" />
                </td>
                <td>
                    <asp:Button ID="b5" runat="server" CssClass="auto-style17" Height="200px" OnClick="b5_Click" Width="200px" Text="Memoria" />
                </td>
            </tr>
        </table>
        <asp:Button ID="Comenzar" runat="server" BorderStyle="None" CssClass="auto-style18" OnClick="Comenzar_Click" Text="Comenzar" />
    </form>
</body>
</html>
