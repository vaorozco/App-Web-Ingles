<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MenúAdmin.aspx.cs" Inherits="Fonet_Web.MenúAdmin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            top: 194px;
            left: 1010px;
            position: absolute;
            height: 287px;
        }
        .auto-style2 {
            height: 40px;
            position: absolute;
            left: 13px;
            top: 16px;
            width: 99px;
            right: 833px;
            margin-top: 0px;
        }
        .auto-style3 {
            top: 204px;
            left: 171px;
            position: absolute;
            height: 287px;
        }
        .auto-style4 {
            top: 203px;
            left: 584px;
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
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
                <asp:ImageButton ID="ImageButton4" runat="server" CssClass="auto-style2" ImageUrl="~/Recursos/Letra.png" />
                <table class="auto-style5">
                    <tr>
                        <td class="auto-style6">
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="30px" ImageUrl="~/Recursos/menuicon.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton9" runat="server" Height="30px" ImageUrl="~/Recursos/gamepad.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" />
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
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/Recursos/Icono BF.png" Width="335px" CssClass="auto-style3" />
            <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/Recursos/icono juego.png" Width="335px" CssClass="auto-style4" />
        </div>
        <p>
            <asp:ImageButton ID="ImageButton3" runat="server" ImageUrl="~/Recursos/Icono G.png" OnClick="ImageButton3_Click" Width="335px" CssClass="auto-style1" />
            <table class="auto-style8">
                <tr>
                    <td class="auto-style9">
                        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td class="auto-style7">
                        <asp:Button ID="Button1" runat="server" BorderStyle="None" Text="Cerrar Sesión" />
                    </td>
                </tr>
            </table>
        </p>
    </form>
</body>
</html>
