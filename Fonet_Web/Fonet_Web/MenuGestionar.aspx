<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MenuGestionar.aspx.cs" Inherits="Fonet_Web.MenuGestionar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            top: 194px;
            left: 598px;
            position: absolute;
            height: 287px;
        }
        .auto-style2 {
            top: 185px;
            left: 170px;
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
            top: 205px;
            left: 1012px;
            position: absolute;
            height: 287px;
        }
        .auto-style8 {
            top: 15px;
            left: 13px;
            position: absolute;
            height: 41px;
            width: 99px;
        }
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
                <asp:ImageButton ID="ImageButton4" runat="server" CssClass="auto-style8" ImageUrl="~/Recursos/Letra.png" />
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
        </p>
    </form>
</body>
</html>
