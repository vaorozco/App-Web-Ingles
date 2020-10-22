<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarPalabra.aspx.cs" Inherits="Fonet_Web.GestionarPalabra" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 69px;
            position: absolute;
            left: 815px;
            top: 94px;
            width: 41%;
        }
        .auto-style2 {
            width: 93px;
        }
        .auto-style3 {
            width: 245px;
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
        </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
            <asp:ImageButton ID="ImageButton13" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
        </asp:Panel>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 499px; left: 1300px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 503px; left: 1154px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" OnClick="ImageButton2_Click" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 501px; left: 1016px; position: absolute" Width="56px" ImageUrl="~/Recursos/cerrar.png" OnClick="ImageButton3_Click" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 621px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
        <p>
            &nbsp;</p>
        <table class="auto-style1">
            <tr>
                <td class="auto-style2">Nombre:</td>
                <td colspan="2">
                    <asp:TextBox ID="TextBox1" runat="server" Width="469px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Imagen:</td>
                <td class="auto-style3">
                    <asp:Image ID="Image1" runat="server" Height="200px" Width="200px" />
                </td>
                <td>
                    <asp:FileUpload ID="FileUpload1" runat="server" />
                    <asp:ImageButton ID="ImageButton4" runat="server" Height="22px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton4_Click" Width="22px" />
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Sonido:</td>
                <td class="auto-style3">
                    <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                </td>
                <td>
                    <asp:FileUpload ID="FileUpload2" runat="server" />
                    <asp:ImageButton ID="ImageButton5" runat="server" Height="22px" ImageUrl="~/Recursos/anadir.png" Width="22px" OnClick="ImageButton5_Click1" />
                </td>
            </tr>
            <tr>
                <td class="auto-style2">Fonema:</td>
                <td class="auto-style3">
                    <asp:DropDownList ID="DropDownList1" runat="server" Width="199px">
                    </asp:DropDownList>
                </td>
                <td>
                    &nbsp;</td>
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
    </form>
</body>
</html>
