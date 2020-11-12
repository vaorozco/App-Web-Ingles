<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Pruebas.aspx.cs" Inherits="Fonet_Web.Pruebas" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 142px;
            height: 135px;
            position: absolute;
            left: 328px;
            top: 152px;
        }
        .auto-style2 {
            width: 34px;
            height: 70px;
            position: absolute;
            left: 495px;
            top: 152px;
            right: 315px;
            vertical-align: middle;
        }
        .auto-style3 {
            width: 56px;
            height: 26px;
            position: absolute;
            top: 151px;
            left: 649px;
        }
        .auto-style4 {
            text-align: justify;
        }
    </style>
</head>
<body style="height: 382px">
    <form id="form1" runat="server">
        <div class="auto-style4">
        <div>
            <asp:ImageButton ID="ImageButton1" runat="server" CssClass="auto-style1" Height="135px" Width="135px" />
        </div>
            <asp:Label ID="Label1" runat="server" CssClass="auto-style2" Height="135px" Text="Label" Width="135px"></asp:Label>
            <asp:Button ID="Button1" runat="server" CssClass="auto-style3" Height="135px" Text="Button" Width="135px" />
        </div>
    </form>
</body>
</html>
