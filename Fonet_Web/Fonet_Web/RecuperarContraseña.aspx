<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecuperarContraseña.aspx.cs" Inherits="Fonet_Web.RecuperarContraseña" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 384px;
            height: 19px;
            position: absolute;
            left: 19px;
            top: 21px;
            font-family: Arial, Helvetica, sans-serif;
        }
        .auto-style2 {
            width: 335px;
            height: 22px;
            position: absolute;
            left: 55px;
            top: 56px;
        }
        .auto-style3 {
            width: 92px;
            position: absolute;
            left: 350px;
            top: 96px;
            color: #FFFFFF;
            background-color: #009900;
        }
        .auto-style4 {
            width: 223px;
            height: 19px;
            position: absolute;
            left: 57px;
            top: 88px;
            font-family: Arial, Helvetica, sans-serif;
            color: #FF0000;
        }
    </style>
</head>
<body style="width: 438px; height: 120px; margin-right: 17px; margin-bottom: 16px;">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="118px" Width="440px">
                <asp:Label ID="Label1" runat="server" Text="Ingrese el correo electronico asociado a tu cuenta" CssClass="auto-style1"></asp:Label>
                <asp:TextBox ID="TextBox1" runat="server" CssClass="auto-style2"></asp:TextBox>
                <asp:Button ID="Button1" runat="server" CssClass="auto-style3" OnClick="Button1_Click" Text="Recuperar" />
                <asp:Label ID="Label2" runat="server" CssClass="auto-style4" Text="Error con los datos ingresados" Visible="False"></asp:Label>
            </asp:Panel>
        </div>
    </form>
</body>
</html>
