<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarFonema.aspx.cs" Inherits="Fonet_Web.GestionarFonema" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 69px;
            position: absolute;
            left: 806px;
            top: 158px;
            width: 41%;
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
            top: 438px;
            left: 1301px;
            position: absolute;
        }
        .auto-style8 {
            top: 158px;
            left: 45px;
            position: absolute;
            height: 348px;
            width: 621px;
        }
        .auto-style9 {
            top: 438px;
            left: 1220px;
            position: absolute;
        }
        .auto-style10 {
            top: 439px;
            left: 1137px;
            position: absolute;
        }
        .auto-style11 {
            height: 56px;
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
            width: 93px;
            font-family: Arial, Helvetica, sans-serif;
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
            background-color: #006600;
        }
        .auto-style18 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
        }
        .auto-style19 {
            width: 163px;
        }
        .auto-style21 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 805px;
            top: 86px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
        }
        .auto-style22 {
            width: 263px;
        }
        </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server" class="auto-style11">
        <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
            <asp:ImageButton ID="ImageButton13" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
            <table class="auto-style15">
                <tr>
                    <td class="auto-style16">
                        <asp:Label ID="Label3" runat="server" CssClass="auto-style18" Text="Label" Visible="False"></asp:Label>
                    </td>
                    <td>
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style17" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
        </asp:Panel>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" CssClass="auto-style7" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" Width="58px" ImageUrl="~/Recursos/comprobar.png" OnClick="ImageButton2_Click" CssClass="auto-style9" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" Width="56px" ImageUrl="~/Recursos/cerrar.png" OnClick="ImageButton3_Click" CssClass="auto-style10" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" CellPadding="4" CssClass="auto-style8" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" />
            <EditRowStyle BackColor="#7C6F57" />
            <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="#E3EAEB" />
            <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
            <SortedAscendingCellStyle BackColor="#F8FAFA" />
            <SortedAscendingHeaderStyle BackColor="#246B61" />
            <SortedDescendingCellStyle BackColor="#D4DFE1" />
            <SortedDescendingHeaderStyle BackColor="#15524A" />
        </asp:GridView>
        <p>
            <asp:Label ID="Label4" runat="server" CssClass="auto-style21" Text="Fonema"></asp:Label>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Gestionar Fonema"></asp:Label>
        </p>
        <table class="auto-style1">
            <tr>
                <td class="auto-style13">Nombre:</td>
                <td colspan="2">
                    <asp:TextBox ID="TextBox1" runat="server" Width="469px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style13">Imagen:</td>
                <td class="auto-style19">
                    <asp:Image ID="Image1" runat="server" Height="200px" Width="200px" />
                </td>
                <td class="auto-style22">
                    <asp:FileUpload ID="FileUpload1" runat="server" />
                    <asp:ImageButton ID="ImageButton4" runat="server" Height="22px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton4_Click" Width="22px" />
                </td>
            </tr>
            <tr>
                <td class="auto-style13">Sonido:</td>
                <td class="auto-style19">
                    <asp:Label ID="Label1" runat="server" Text="Ruta" CssClass="auto-style13" Visible="False"></asp:Label>
                    <asp:Label ID="Label5" runat="server" CssClass="auto-style13" Text="Nombre"></asp:Label>
                </td>
                <td class="auto-style22">
                    <asp:FileUpload ID="FileUpload2" runat="server" />
                    <asp:ImageButton ID="ImageButton14" runat="server" Height="22px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton14_Click" Width="22px" />
                    <asp:ImageButton ID="ImageButton5" runat="server" Height="22px" ImageUrl="~/Recursos/altavoz.png" Width="22px" OnClick="ImageButton5_Click1" />
                </td>
            </tr>
        </table>
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
    </form>
</body>
</html>
