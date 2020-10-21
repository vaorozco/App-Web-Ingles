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
            top: 20px;
            left: 14px;
            position: absolute;
            width: 1249px;
            height: 469px;
        }
        .auto-style2 {
            width: 211px;
            height: 176px;
            top: 167px;
            left: 81px;
            position: absolute;
        }
    </style>
</head>
<body style="height: 475px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" BackColor="Silver" Height="469px" style="background-color: Silver" CssClass="auto-style1">
            <asp:Panel ID="Panel2" runat="server" BackColor="White" style="top: 178px; left: 798px; position: absolute; height: 284px; width: 449px">
                <asp:Button ID="Registrarse" runat="server" OnClick="Registrarse_Click" style="top: 219px; left: 177px; position: absolute; height: 26px; width: 131px; background-color: White" Text="Registarse" />
                <asp:TextBox ID="TextBox1" runat="server" ForeColor="Gray" OnTextChanged="Page_Load" style="top: 63px; left: 2px; position: absolute; height: 32px; width: 372px; background-color: White; margin-left: 34px; margin-right: 31px;">Usuario</asp:TextBox>
                &nbsp;<asp:Label ID="Label1" runat="server" style="top: 12px; left: 14px; position: absolute; height: 22px; width: 132px; font-family: Montserrat-Thin; background-color: White" Text="Iniciar sesión"></asp:Label>
                <asp:TextBox ID="TextBox2" runat="server" ForeColor="Gray" OnTextChanged="Page_Load" style="top: 120px; left: 36px; position: absolute; height: 32px; width: 372px; background-color: White" TextMode="Password"></asp:TextBox>
                <asp:Button ID="Button1" runat="server" BorderStyle="None" OnClick="Button1_Click" style="top: 252px; left: 167px; position: absolute; height: 26px; width: 153px; background-color: White; color: #3399FF;" Text="¿Olvidaste tu contraseña?" />
                <asp:Button ID="Ingresar" runat="server" BackColor="#33CC33" BorderColor="#009933" Font-Bold="False" Font-Underline="False" ForeColor="White" style="top: 183px; left: 177px; position: absolute; height: 26px; width: 130px; background-color: #009933; font-size: medium; font-family: Montserrat-Thin;" Text="Ingresar" OnClick="Ingresar_Click" />
            </asp:Panel>
            <asp:Image ID="Image1" runat="server" ImageUrl="~/Recursos/logo.png" style="background-color: Silver;" CssClass="auto-style2" />
        </asp:Panel>
    </form>
</body>
</html>
