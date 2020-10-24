<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="registrar.aspx.cs" Inherits="Fonet_Web.registrar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style8 {
            top: 380px;
            left: 160px;
            position: absolute;
            height: 26px;
            width: 88px;
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
            background-color: #009933;
        }
        .auto-style9 {
            top: 24px;
            left: 18px;
            position: absolute;
            height: 19px;
            width: 60px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: large;
        }
        .auto-style11 {
            width: 99%;
            height: 310px;
            position: absolute;
            left: 14px;
            top: 65px;
        }
        .auto-style13 {
            width: 392px;
        }
        .auto-style14 {
            width: 87px;
        }
        .auto-style15 {
            font-family: Arial, Helvetica, sans-serif;
            color: #808080;
        }
        .auto-style16 {
            position: absolute;
            left: 285px;
            top: 20px;
            width: 113px;
            height: 41px;
        }
        .auto-style17 {
            width: 201px;
            height: 18px;
            position: absolute;
            left: 107px;
            top: 349px;
            font-family: Arial, Helvetica, sans-serif;
            color: #FF0000;
        }
        .auto-style18 {
            width: 282px;
            height: 19px;
            position: absolute;
            left: 18px;
            top: 51px;
            font-family: Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body style="width: 398px; height: 395px">
    <form id="form1" runat="server">
        <div class="auto-style13">
            <asp:Panel ID="Panel1" runat="server" Height="400px" Width="400px">
                <asp:Button ID="Registar2" runat="server" OnClick="Button1_Click" Text="Registrar" CssClass="auto-style8" />
                <asp:Label ID="Label1" runat="server" Text="Registro" CssClass="auto-style9"></asp:Label>
                <table class="auto-style11">
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label2" runat="server" Text="Nombre:" CssClass="auto-style15"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox1" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label3" runat="server" Text="Apellido:" CssClass="auto-style15"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox2" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label4" runat="server" Text="Correo:" CssClass="auto-style15"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox3" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label5" runat="server" Text="Contraseña:" CssClass="auto-style15"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox4" runat="server" Width="270px" TextMode="Password"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label6" runat="server" Text="Repetir Contraseña:" CssClass="auto-style15"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox5" runat="server" Width="270px" TextMode="Password"></asp:TextBox>
                        </td>
                    </tr>
                </table>
                <asp:Image ID="Image1" runat="server" CssClass="auto-style16" ImageUrl="~/Recursos/logo.png" />
                <asp:Label ID="Label7" runat="server" CssClass="auto-style17" Text="Contraseñas no coinciden" Visible="False"></asp:Label>
                <asp:Label ID="Label8" runat="server" CssClass="auto-style18" Text="Por favor ingrese los siguientes datos"></asp:Label>
            </asp:Panel>
        </div>
    </form>
</body>
</html>
