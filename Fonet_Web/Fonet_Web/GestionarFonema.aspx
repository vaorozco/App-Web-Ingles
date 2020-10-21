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
        <asp:TextBox ID="TextBox1" runat="server" style="top: 135px; left: 847px; position: absolute; height: 22px; width: 518px"></asp:TextBox>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" style="top: 499px; left: 1300px; position: absolute" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" style="top: 503px; left: 1154px; position: absolute" Width="58px" ImageUrl="~/Recursos/comprobar.png" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" style="top: 501px; left: 1016px; position: absolute" Width="56px" ImageUrl="~/Recursos/cerrar.png" />
        <asp:GridView ID="GridView1" runat="server" AutoGenerateSelectButton="True" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" style="top: 90px; left: 51px; position: absolute; height: 348px; width: 621px">
            <SelectedRowStyle BackColor="#33CCFF" />
        </asp:GridView>
        <asp:Image ID="Image1" runat="server" style="top: 172px; left: 852px; position: absolute; height: 215px; width: 246px" />
        <asp:FileUpload ID="FileUpload1" runat="server" style="top: 367px; left: 1110px; position: absolute; height: 22px; width: 217px" />
        <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton4_Click" style="top: 364px; left: 1339px; position: absolute; height: 23px; width: 26px" />
        <p>
        <asp:ImageButton ID="ImageButton5" runat="server" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton5_Click" style="top: 429px; left: 1339px; position: absolute; height: 23px; width: 26px" />
        </p>
        <asp:FileUpload ID="FileUpload2" runat="server" style="top: 431px; left: 1112px; position: absolute; height: 22px; width: 217px" />
    </form>
</body>
</html>
