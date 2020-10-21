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
        }
        .auto-style9 {
            top: 24px;
            left: 18px;
            position: absolute;
            height: 19px;
            width: 60px;
        }
        .auto-style11 {
            width: 99%;
            height: 310px;
            position: absolute;
            left: 14px;
            top: 65px;
        }
        .auto-style12 {
            width: 70px;
        }
        .auto-style13 {
            width: 392px;
        }
        .auto-style14 {
            width: 87px;
        }
    </style>
</head>
<body style="width: 398px; height: 395px">
    <form id="form1" runat="server">
        <div class="auto-style13">
            <asp:Panel ID="Panel1" runat="server" Height="400px" Width="400px">
                <asp:Button ID="Registar2" runat="server" OnClick="Button1_Click" Text="Registrar" CssClass="auto-style8" />
                <asp:Label ID="Label1" runat="server" Text="Registrate" CssClass="auto-style9"></asp:Label>
                <table class="auto-style11">
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label2" runat="server" Text="Nombre:"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox1" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label3" runat="server" Text="Apellido:"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox2" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label4" runat="server" Text="Correo:"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox3" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label5" runat="server" Text="Contraseña:"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox4" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                    <tr>
                        <td class="auto-style14">
                            <asp:Label ID="Label6" runat="server" Text="Repetir Contraseña:"></asp:Label>
                        </td>
                        <td>
                            <asp:TextBox ID="TextBox5" runat="server" Width="270px"></asp:TextBox>
                        </td>
                    </tr>
                </table>
            </asp:Panel>
        </div>
    </form>
</body>
</html>
