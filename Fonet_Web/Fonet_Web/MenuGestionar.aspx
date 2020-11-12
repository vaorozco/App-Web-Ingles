<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MenuGestionar.aspx.cs" Inherits="Fonet_Web.MenuGestionar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            top: 222px;
            left: 542px;
            position: absolute;
            height: 287px;
        }
        .auto-style2 {
            top: 225px;
            left: 87px;
            position: absolute;
            height: 287px;
        }
        .auto-style5 {
            width: 26%;
            height: 32px;
            position: absolute;
            left: 526px;
            top: 16px;
        }
        .auto-style6 {
            width: 66px;
        }
        .auto-style7 {
            top: 220px;
            left: 991px;
            position: absolute;
            height: 287px;
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
            margin-left: 0px;
        }
        .auto-style15 {
            width: 355px;
            height: 26px;
            position: absolute;
            left: 1016px;
            top: 19px;
        }
        .auto-style16 {
            width: 239px;
        }
        .auto-style17 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
        }
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
                <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
                <table class="auto-style15">
                    <tr>
                        <td class="auto-style16">
                            <asp:Label ID="Label1" runat="server" CssClass="auto-style17" Text="Label"></asp:Label>
                        </td>
                        <td>
                            <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                        </td>
                    </tr>
                </table>
            </asp:Panel>
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/Recursos/Icono GU.png" Width="335px" CssClass="auto-style2" OnClick="ImageButton1_Click" />
            <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/Recursos/Icono GF.png" Width="335px" CssClass="auto-style1" OnClick="ImageButton2_Click" />
        </div>
        <p>
            <asp:ImageButton ID="ImageButton3" runat="server" ImageUrl="~/Recursos/Icono GP.png" OnClick="ImageButton3_Click" Width="335px" CssClass="auto-style7" />
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
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Menú Gestionar"></asp:Label>
        </p>
    </form>
</body>
</html>
