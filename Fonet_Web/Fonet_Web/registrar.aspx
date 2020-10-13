<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="registrar.aspx.cs" Inherits="Fonet_Web.registrar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="400px" Width="400px">
                <asp:TextBox ID="TextBox4" runat="server" Height="28px" style="top: 95px; left: 35px; position: absolute" Width="338px"></asp:TextBox>
                <asp:TextBox ID="TextBox3" runat="server" Height="28px" style="top: 53px; left: 36px; position: absolute" Width="338px"></asp:TextBox>
                <asp:TextBox ID="TextBox5" runat="server" Height="28px" style="top: 148px; left: 35px; position: absolute" Width="338px"></asp:TextBox>
                <asp:TextBox ID="TextBox6" runat="server" Height="28px" style="top: 205px; left: 33px; position: absolute" Width="338px"></asp:TextBox>
                <asp:Button ID="Registar2" runat="server" OnClick="Button1_Click" style="top: 335px; left: 171px; position: absolute; height: 26px; width: 56px" Text="Registrar" />
                <asp:Label ID="Label1" runat="server" style="top: 24px; left: 26px; position: absolute; height: 19px; width: 60px" Text="Registrate"></asp:Label>
                <asp:TextBox ID="TextBox7" runat="server" Height="28px" style="top: 261px; left: 31px; position: absolute" Width="338px"></asp:TextBox>
            </asp:Panel>
        </div>
    </form>
</body>
</html>
