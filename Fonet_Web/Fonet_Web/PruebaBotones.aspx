<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PruebaBotones.aspx.cs" Inherits="Fonet_Web.PruebaBotones" %>

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
            width: 66px;
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
            color: #FFFFFF;
            font-family: Arial, Helvetica, sans-serif;
        }
        .auto-style21 {
            width: 1293px;
            height: 449px;
            position: absolute;
            left: 49px;
            top: 146px;
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
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px"  />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton11" runat="server" Height="30px" ImageUrl="~/Recursos/ajustes.png" Width="30px" />
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
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" style="height: 22px" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Banco Fonemas"></asp:Label>
        </p>
        <asp:Panel ID="Panel2" runat="server" CssClass="auto-style21">
        </asp:Panel>
    </form>
</body>
</html>
