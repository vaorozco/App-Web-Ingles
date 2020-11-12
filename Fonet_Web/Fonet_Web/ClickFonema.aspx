<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ClickFonema.aspx.cs" Inherits="Fonet_Web.ClickFonema" %>

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
        .auto-style15 {
            width: 524px;
            height: 412px;
            position: absolute;
            left: 51px;
            top: 192px;
        }
        .auto-style16 {
            height: 420px;
            position: absolute;
            left: 787px;
            top: 122px;
            width: 41%;
            margin-top: 0px;
            margin-bottom: 0px;
        }
        .auto-style17 {
            height: 71px;
        }
        .auto-style18 {
            height: 71px;
            width: 259px;
        }
        .auto-style19 {
            height: 71px;
            width: 216px;
        }
        .auto-style20 {
            background-color: #FFFFFF;
        }
        .auto-style21 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
        }
        .auto-style22 {
            height: 314px;
        }
        .auto-style25 {
            height: 72px;
        }
        .auto-style26 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 5px;
            top: 108px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
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
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="30px" ImageUrl="~/Recursos/menuicon.png" Width="30px" OnClick="ImageButton8_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton9" runat="server" Height="30px" ImageUrl="~/Recursos/gamepad.png" Width="30px" OnClick="ImageButton9_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" OnClick="ImageButton10_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton11" runat="server" Height="30px" ImageUrl="~/Recursos/ajustes.png" Width="30px" OnClick="ImageButton11_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton12" runat="server" Height="30px" ImageUrl="~/Recursos/usuario.png" Width="30px" OnClick="ImageButton12_Click" />
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
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" style="height: 22px" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Fonema"></asp:Label>
        </p>
        <asp:Image ID="Image1" runat="server" CssClass="auto-style15" Height="420px" />
        <table class="auto-style16">
            <tr>
                <td class="auto-style19">
                    <asp:Label ID="Label3" runat="server" Text="Label" CssClass="auto-style21" Visible="False"></asp:Label>
                </td>
                <td class="auto-style18">
                    <asp:Label ID="Label5" runat="server" Text="Ruta" Visible="False"></asp:Label>
                </td>
                <td class="auto-style17">
                    <asp:ImageButton ID="ReproducirFonema" runat="server" OnClick="ImageButton13_Click" Height="70px" ImageUrl="~/Recursos/altavoz.png" Width="70px" />
                </td>
            </tr>
            <tr>
                <td class="auto-style25" colspan="3">
                    <asp:Label ID="Label4" runat="server" CssClass="auto-style26" Text="Ejemplos"></asp:Label>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="auto-style22">
                    <asp:Panel ID="Panel2" runat="server" CssClass="auto-style20" Height="309px" Width="364px">
                    </asp:Panel>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
