<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="Fonet_Web.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #Password1 {
            top: 127px;
            left: 35px;
            position: absolute;
            height: 30px;
            width: 373px;
        }
        .auto-style1 {
            top: 3px;
            left: 3px;
            position: absolute;
            width: 1367px;
            height: 657px;
        }
        .auto-style2 {
            width: 294px;
            height: 220px;
            top: 195px;
            left: 115px;
            position: absolute;
        }
        .auto-style3 {
            top: 199px;
            left: 806px;
            position: absolute;
            height: 284px;
            width: 449px;
        }
        .auto-style4 {
            font-family: Arial, Helvetica, sans-serif;
            top: 183px;
            left: 156px;
            position: absolute;
            height: 26px;
            width: 130px;
        }
        .auto-style5 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: large;
        }
        .auto-style6 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: medium;
            color: #FFFFFF;
            background-color: #6699FF;
            top: 221px;
            left: 155px;
            position: absolute;
            height: 26px;
            width: 131px;
        }
        .auto-style7 {
            width: 20%;
            height: 46px;
            position: absolute;
            left: 134px;
            top: 407px;
        }
        .auto-style8 {
            top: 252px;
            left: 146px;
            position: absolute;
            height: 26px;
            width: 153px;
        }
        .auto-style9 {
            top: 120px;
            left: 1px;
            position: absolute;
            height: 32px;
            width: 372px;
            margin-left: 35px;
            margin-right: 32px;
        }
        .auto-style10 {
            width: 226px;
            height: 20px;
            position: absolute;
            left: 36px;
            top: 160px;
            font-family: Arial, Helvetica, sans-serif;
            color: #FF0000;
        }
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" BackColor="Silver" style="background-color: Silver" CssClass="auto-style1">
            <asp:Panel ID="Panel2" runat="server" BackColor="White" CssClass="auto-style3">
                <asp:Button ID="Registrarse" runat="server" OnClick="Registrarse_Click" Text="Crear Cuenta" CssClass="auto-style6" />
                <asp:TextBox ID="TextBox1" runat="server" ForeColor="Gray" OnTextChanged="Page_Load" style="top: 63px; left: 2px; position: absolute; height: 32px; width: 372px; background-color: White; margin-left: 34px; margin-right: 31px;">USUARIO</asp:TextBox>
                &nbsp;<asp:Label ID="Label1" runat="server" style="top: 12px; left: 14px; position: absolute; height: 22px; width: 132px; font-family: Arial, Helvetica, sans-serif; background-color: White" Text="Iniciar sesión" CssClass="auto-style5"></asp:Label>
                <asp:TextBox ID="TextBox2" runat="server" ForeColor="Gray" OnTextChanged="Page_Load" style="background-color: White" TextMode="Password" CssClass="auto-style9">CONTRASEÑA</asp:TextBox>
                <asp:Button ID="Button1" runat="server" BorderStyle="None" OnClick="Button1_Click" style="background-color: White; color: #3399FF;" Text="¿Olvidaste tu contraseña?" CssClass="auto-style8" />
                <asp:Button ID="Ingresar" runat="server" BackColor="#33CC33" BorderColor="#009933" Font-Bold="False" Font-Underline="False" ForeColor="White" style="background-color: #009933; font-size: medium; font-family: Arial, Helvetica, sans-serif;" Text="Iniciar Sesión" OnClick="Ingresar_Click" CssClass="auto-style4" />
                <asp:Label ID="Label4" runat="server" CssClass="auto-style10" style="background-color: White" Text="Label" Visible="False"></asp:Label>
            </asp:Panel>
            <asp:Image ID="Image1" runat="server" ImageUrl="~/Recursos/logo.png" style="background-color: Silver;" CssClass="auto-style2" />
            <table class="auto-style7">
                <tr>
                    <td>
                        <asp:Label ID="Label2" runat="server" Text="Aprende los fonemas de manera " CssClass="auto-style5"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <asp:Label ID="Label3" runat="server" Text="rápida y sencilla" CssClass="auto-style5"></asp:Label>
                    </td>
                </tr>
            </table>
        </asp:Panel>
    </form>
</body>
</html>
