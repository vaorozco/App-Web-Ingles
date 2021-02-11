<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Perfil.aspx.cs" Inherits="Fonet_Web.Perfil" %>

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
            height: 417px;
            position: absolute;
            left: 45px;
            top: 158px;
            width: 92%;
        }
        .auto-style16 {
            width: 205px;
        }
        .auto-style17 {
            width: 20%;
            height: 33px;
            position: absolute;
            left: 454px;
            top: 598px;
        }
        .auto-style19 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: x-large;
        }
        .auto-style20 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: x-large;
            color: #999999;
        }
        .auto-style21 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: large;
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
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Perfil"></asp:Label>
        </p>
        <table class="auto-style15">
            <tr>
                <td class="auto-style16">
                    <asp:Label ID="Label3" runat="server" Text="Nombre:" CssClass="auto-style19"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="TextBox1" runat="server" Height="29px" Width="695px" CssClass="auto-style21"></asp:TextBox>
                    <asp:Label ID="Label8" runat="server" Text="Label" CssClass="auto-style20"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style16">
                    <asp:Label ID="Label4" runat="server" Text="Apellido:" CssClass="auto-style19"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="TextBox2" runat="server" Height="30px" Width="695px" CssClass="auto-style21"></asp:TextBox>
                    <asp:Label ID="Label9" runat="server" Text="Label" CssClass="auto-style20"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style16">
                    <asp:Label ID="Label7" runat="server" Text="Correo:" CssClass="auto-style19"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="TextBox3" runat="server" Height="30px" Width="695px" CssClass="auto-style21"></asp:TextBox>
                    <asp:Label ID="Label10" runat="server" Text="Label" CssClass="auto-style20"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style16">
                    <asp:Label ID="Label5" runat="server" Text="Contraseña:" CssClass="auto-style19"></asp:Label>
                </td>
                <td>
                    <asp:TextBox ID="TextBox4" runat="server" Height="30px" Width="695px" CssClass="auto-style21"></asp:TextBox>
                    <asp:Label ID="Label11" runat="server" Text="Label" CssClass="auto-style20"></asp:Label>
                </td>
            </tr>
        </table>
        <table class="auto-style17">
            <tr>
                <td>
                    <asp:Button ID="Modificar" runat="server" Height="30px" Text="Modificar" Width="120px" OnClick="Button3_Click" />
                </td>
                <td>
                    <asp:Button ID="Guardar" runat="server" Height="30px" Text="Guardar" Width="120px" OnClick="Button4_Click" />
                </td>
                <td>
                    <asp:Button ID="Cancelar" runat="server" Height="30px" Text="Cancelar" Width="120px" OnClick="Cancelar_Click" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
