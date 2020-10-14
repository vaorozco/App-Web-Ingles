<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarFonema.aspx.cs" Inherits="Fonet_Web.GestionarFonema" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="height: 634px; width: 1502px">
    <form id="form1" runat="server">
        <asp:Panel ID="Panel1" runat="server" Height="33px" style="background-color: #006600">
        </asp:Panel>
        <asp:TextBox ID="TextBox1" runat="server" style="top: 131px; left: 930px; position: absolute; height: 22px; width: 540px"></asp:TextBox>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 509px; left: 1420px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 506px; left: 1304px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 505px; left: 1183px; position: absolute" Width="56px" ImageUrl="~/Recursos/cerrar.png" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 621px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
        <asp:Image ID="Image1" runat="server" style="top: 177px; left: 1176px; position: absolute; height: 186px; width: 187px" />
        <asp:FileUpload ID="FileUpload1" runat="server" style="top: 388px; left: 1214px; position: absolute; height: 22px; width: 217px" />
        <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton4_Click" style="top: 388px; left: 1442px; position: absolute; height: 23px; width: 26px" />
        <p>
        <asp:ImageButton ID="ImageButton5" runat="server" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton5_Click" style="top: 430px; left: 1443px; position: absolute; height: 23px; width: 26px" />
        </p>
    </form>
</body>
</html>
