<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MenúAdmin.aspx.cs" Inherits="Fonet_Web.MenúAdmin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="24px" style="background-color: #006600">
            </asp:Panel>
            <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/Recursos/Icono BF.png" style="top: 153px; left: 272px; position: absolute; height: 287px" Width="335px" />
            <asp:ImageButton ID="ImageButton2" runat="server" ImageUrl="~/Recursos/icono juego.png" style="top: 172px; left: 604px; position: absolute; height: 287px" Width="335px" />
        </div>
        <p>
            <asp:ImageButton ID="ImageButton3" runat="server" ImageUrl="~/Recursos/Icono BF.png" OnClick="ImageButton3_Click" style="top: 157px; left: 947px; position: absolute; height: 287px" Width="335px" />
        </p>
    </form>
</body>
</html>
