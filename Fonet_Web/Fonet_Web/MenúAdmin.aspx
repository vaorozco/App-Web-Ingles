<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MenúAdmin.aspx.cs" Inherits="Fonet_Web.MenúAdmin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            top: 210px;
            left: 959px;
            position: absolute;
            height: 287px;
        }
        .auto-style3 {
            top: 214px;
            left: 113px;
            position: absolute;
            height: 287px;
            right: 739px;
        }
        .auto-style4 {
            top: 209px;
            left: 538px;
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
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/Recursos/Icono BF.png" Width="335px" CssClass="auto-style3" OnClick="ImageButton1_Click" />
            <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/Recursos/icono juego.png" Width="335px" CssClass="auto-style4" OnClick="ImageButton2_Click" />
        </div>
        <p>
            <asp:ImageButton ID="ImageButton3" runat="server" ImageUrl="~/Recursos/Icono G.png" OnClick="ImageButton3_Click" Width="335px" CssClass="auto-style1" />
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
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Menú"></asp:Label>
        </p>
    </form>
</body>
</html>
