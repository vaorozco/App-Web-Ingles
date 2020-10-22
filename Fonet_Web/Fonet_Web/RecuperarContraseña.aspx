<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RecuperarContraseña.aspx.cs" Inherits="Fonet_Web.RecuperarContraseña" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 210px;
            height: 19px;
            position: absolute;
            left: 118px;
            top: 27px;
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
            height: 26px;
            position: absolute;
            left: 350px;
            top: 96px;
            color: #FFFFFF;
            background-color: #009900;
        }
    </style>
</head>
<body style="width: 438px; height: 120px; margin-right: 17px; margin-bottom: 16px;">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="118px" Width="440px">
                <asp:Label ID="Label1" runat="server" Text="Ingrese el Correo Electronico" CssClass="auto-style1"></asp:Label>
                <asp:TextBox ID="TextBox1" runat="server" CssClass="auto-style2"></asp:TextBox>
                <asp:Button ID="Button1" runat="server" CssClass="auto-style3" OnClick="Button1_Click" Text="Recuperar" />
            </asp:Panel>
        </div>
    </form>
</body>
</html>
