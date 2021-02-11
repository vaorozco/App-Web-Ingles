<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Pareo2.aspx.cs" Inherits="Fonet_Web.Pareo2" %>

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
            width: 448px;
            height: 393px;
            position: absolute;
            left: 52px;
            top: 135px;
        }
        .auto-style18 {
            width: 577px;
            height: 96px;
            position: absolute;
            left: 785px;
            top: 171px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #000000;
        }
        .auto-style19 {
            width: 141px;
            height: 43px;
            position: absolute;
            left: 1148px;
            top: 585px;
            color: #FFFFFF;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            background-color: #009900;
        }
        .auto-style20 {
            height: 142px;
            position: absolute;
            left: 786px;
            top: 252px;
            width: 37%;
        }
        .auto-style21 {
            background-color: #FFFFFF;
        }
        .auto-style22 {
            background-color: #FFFFFF;
            font-size: x-large;
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
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Adivinanza"></asp:Label>
        </p>
        <asp:ImageButton ID="Altavoz" runat="server" CssClass="auto-style15" Height="500px" ImageUrl="~/Recursos/altavoz.png" OnClick="Altavoz_Click" Width="500px" />
        <asp:Label ID="Label3" runat="server" CssClass="auto-style18" Text="¿Sabes cúal palabra es la siguiente?"></asp:Label>
        <table class="auto-style20">
            <tr>
                <td>
                    <asp:Button ID="Palabra1" runat="server" CssClass="auto-style22" Height="145px" Text="Palabra 1" Width="145px" OnClick="Palabra1_Click" />
                </td>
                <td>
                    <asp:Button ID="Palabra2" runat="server" CssClass="auto-style22" Height="145px" Text="Palabra 2" Width="145px" OnClick="Palabra2_Click" />
                </td>
                <td>
                    <asp:Button ID="Palabra3" runat="server" CssClass="auto-style22" Height="145px" Text="Palabra 3" Width="145px" OnClick="Palabra3_Click" />
                </td>
            </tr>
        </table>
        <p>
        <asp:Button ID="Cargar" runat="server" BorderStyle="None" CssClass="auto-style19" OnClick="Cargar_Click" Text="Cargar" />
        </p>
    </form>
</body>
</html>
