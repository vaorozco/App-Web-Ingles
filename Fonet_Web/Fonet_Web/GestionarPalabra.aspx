<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarPalabra.aspx.cs" Inherits="Fonet_Web.GestionarPalabra" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 69px;
            position: absolute;
            left: 904px;
            top: 108px;
            width: 39%;
        }
        .auto-style2 {
            width: 93px;
        }
        .auto-style3 {
            width: 245px;
        }
        .auto-style4 {
            top: 386px;
            left: 1255px;
            position: absolute;
        }
        .auto-style5 {
            top: 385px;
            left: 1337px;
            position: absolute;
        }
        .auto-style6 {
            top: 385px;
            left: 1424px;
            position: absolute;
        }
    </style>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="33px" style="background-color: #006600">
        </asp:Panel>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" CssClass="auto-style6" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" Width="58px" ImageUrl="~/Recursos/comprobar.png" CssClass="auto-style5" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" Width="56px" ImageUrl="~/Recursos/cerrar.png" CssClass="auto-style4" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 621px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
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
                    <asp:Label ID="Label4" runat="server" Text="Label"></asp:Label>
                </td>
                <td>
                    <asp:FileUpload ID="FileUpload2" runat="server" />
                    <asp:ImageButton ID="ImageButton5" runat="server" Height="22px" ImageUrl="~/Recursos/anadir.png" Width="22px" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
