<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GestionarUsuarios.aspx.cs" Inherits="Fonet_Web.GestionarUsuarios" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 209px;
            position: absolute;
            left: 769px;
            top: 158px;
            width: 39%;
        }
        .auto-style3 {
            width: 100px;
        }
        .auto-style4 {
            width: 457px;
        }
        .auto-style5 {
            width: 26%;
            height: 32px;
            position: absolute;
            left: 526px;
            top: 16px;
        }
        .auto-style6 {
            width: 66px;
        }

        .auto-style8 {
            width: 26%;
            height: 32px;
            position: absolute;
            left: 95px;
            top: 179px;
        }
        
        .auto-style9 {
            top: 160px;
            left: 53px;
            height: 348px;
            width: 550px;
        }
        .auto-style10 {
            font-family: Arial, Helvetica, sans-serif;
        }
        .auto-style12 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 46px;
            top: 88px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
        }
        .auto-style15 {
            width: 355px;
            height: 26px;
            position: absolute;
            left: 1016px;
            top: 19px;
        }
        .auto-style16 {
            width: 239px;
        }
        .auto-style13 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
            background-color: #006600;
            margin-left: 0px;
        }
        
        .auto-style21 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 768px;
            top: 89px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
        }
        .auto-style22 {
            top: 386px;
            left: 1180px;
            position: absolute;
        }
        .auto-style23 {
            top: 384px;
            left: 1090px;
            position: absolute;
            right: 233px;
        }
        .auto-style24 {
            top: 385px;
            left: 1265px;
            position: absolute;
            margin-top: 0px;
        }
        
        .auto-style25 {
            position: absolute;
            left: 50px;
            top: 161px;
            width: 638px;
            height: 387px;
            overflow: scroll;
            margin-right: 94px;
            margin-top: 0px;
        }

        
    </style>
</head>
<body style="height: 42px; width: 1365px">
    <form id="form1" runat="server" class="auto-style19">
        <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600" Width="1367px" CssClass="auto-style13">
            <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
            <table class="auto-style15">
                <tr>
                    <td class="auto-style16">
                        <asp:Label ID="Label1" runat="server" Text="Label" Visible="False"></asp:Label>
                    </td>
                    <td>
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
        </asp:Panel>
        <asp:ImageButton ID="ImageButton1" runat="server" Height="61px" Width="62px" ImageUrl="~/Recursos/anadir.png" OnClick="ImageButton1_Click" CssClass="auto-style24" />
        <asp:ImageButton ID="ImageButton2" runat="server" Height="60px" Width="58px" ImageUrl="~/Recursos/comprobar.png" OnClick="ImageButton2_Click" CssClass="auto-style22" />
        <asp:ImageButton ID="ImageButton3" runat="server" Height="61px" Width="56px" ImageUrl="~/Recursos/cerrar.png" OnClick="ImageButton3_Click" CssClass="auto-style23" />
        <div class="auto-style25">      
            <asp:GridView ID="GridView1" runat="server" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" CellPadding="4" CssClass="auto-style9" ForeColor="#333333" GridLines="None">
                <AlternatingRowStyle BackColor="White" />
                <Columns>
                    <asp:CommandField SelectText="&gt;&gt;" ShowSelectButton="True" />
                </Columns>
                <EditRowStyle BackColor="#7C6F57" />
                <FooterStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
                <HeaderStyle BackColor="#1C5E55" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#666666" ForeColor="White" HorizontalAlign="Center" />
                <RowStyle BackColor="#E3EAEB" />
                <SelectedRowStyle BackColor="#C5BBAF" Font-Bold="True" ForeColor="#333333" />
                <SortedAscendingCellStyle BackColor="#F8FAFA" />
                <SortedAscendingHeaderStyle BackColor="#246B61" />
                <SortedDescendingCellStyle BackColor="#D4DFE1" />
                <SortedDescendingHeaderStyle BackColor="#15524A" />
            </asp:GridView>
        </div>  
        <table class="auto-style1">
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label2" runat="server" Text="Nombre:" CssClass="auto-style10"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox1" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label3" runat="server" Text="Apellido:" CssClass="auto-style10"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox2" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label4" runat="server" Text="Correo" CssClass="auto-style10"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox3" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label5" runat="server" Text="Contraseña:" CssClass="auto-style10"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:TextBox ID="TextBox4" runat="server" Width="457px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style3">
                    <asp:Label ID="Label6" runat="server" Text="Tipo" CssClass="auto-style10"></asp:Label>
                </td>
                <td class="auto-style4">
                    <asp:DropDownList ID="DropDownList1" runat="server" CssClass="auto-style8" Height="16px" Width="128px">
                        <asp:ListItem Value="1">Administrador</asp:ListItem>
                        <asp:ListItem Value="2">Estudiante</asp:ListItem>
                    </asp:DropDownList>
                </td>
            </tr>
        </table>
        <table class="auto-style5">
            <tr>
                <td class="auto-style6">
                    <asp:ImageButton ID="ImageButton8" runat="server" Height="30px" ImageUrl="~/Recursos/menuicon.png" Width="30px" OnClick="ImageButton8_Click" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton9" runat="server" Height="30px" ImageUrl="~/Recursos/gamepad.png" Width="30px" OnClick="ImageButton9_Click" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" OnClick="ImageButton10_Click" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton11" runat="server" Height="30px" ImageUrl="~/Recursos/ajustes.png" Width="30px" OnClick="ImageButton11_Click" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton12" runat="server" Height="30px" ImageUrl="~/Recursos/usuario.png" Width="30px" OnClick="ImageButton12_Click" />
                </td>
            </tr>
        </table>
        <p>
            <asp:Label ID="Label7" runat="server" CssClass="auto-style12" Text="Gestionar Usuario"></asp:Label>
            <asp:Label ID="Label8" runat="server" CssClass="auto-style21" Text="Usuario"></asp:Label>
        </p>
    </form>
</body>
</html>
