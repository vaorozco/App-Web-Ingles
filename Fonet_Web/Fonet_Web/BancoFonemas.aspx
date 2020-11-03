<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BancoFonemas.aspx.cs" Inherits="Fonet_Web.BancoFonemas" %>

<!DOCTYPE html>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
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
        .auto-style7 {
            height: 23px;
        }
        .auto-style8 {
            height: 31px;
            position: absolute;
            left: 1016px;
            top: 18px;
            width: 26%;
        }
        .auto-style9 {
            height: 23px;
            width: 228px;
        }
        .auto-style12 {
            width: 266px;
            height: 19px;
            position: absolute;
            left: 46px;
            top: 75px;
            font-family: Arial, Helvetica, sans-serif;
            font-size: xx-large;
            color: #808080;
        }
        .auto-style13 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
            background-color: #006600;
        }
        .auto-style14 {
            color: #FFFFFF;
            font-family: Arial, Helvetica, sans-serif;
        }
        .auto-style15 {
            width: 93%;
            height: 491px;
            position: absolute;
            left: 51px;
            top: 134px;
        }
        .auto-style16 {
            width: 112px;
            height: 99px;
            left: 4px;
            top: 25px;
        }
        .auto-style18 {
            width: 137px;
        }
        .auto-style19 {
            width: 14px;
            height: 16px;
            left: 147px;
            top: 25px;
        }
        .auto-style20 {
            width: 14px;
            height: 16px;
            left: 285px;
            top: 60px;
        }
    </style>
</head>
<body style="height: 640px; width: 1365px">
    <form id="form1" runat="server">
        <div>
            <asp:Panel ID="Panel1" runat="server" Height="44px" style="background-color: #006600">
                <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/Recursos/Letra.png" Height="40px" Width="96px" />
                <table class="auto-style5">
                    <tr>
                        <td class="auto-style6">
                            <asp:ImageButton ID="ImageButton8" runat="server" Height="30px" ImageUrl="~/Recursos/menuicon.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton9" runat="server" Height="30px" ImageUrl="~/Recursos/gamepad.png" Width="30px" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" OnClick="ImageButton10_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton11" runat="server" Height="30px" ImageUrl="~/Recursos/ajustes.png" Width="30px" OnClick="ImageButton11_Click" />
                        </td>
                        <td>
                            <asp:ImageButton ID="ImageButton12" runat="server" Height="30px" ImageUrl="~/Recursos/usuario.png" Width="30px" />
                        </td>
                    </tr>
                </table>
            </asp:Panel>
        </div>
        <p>
            <table class="auto-style8">
                <tr>
                    <td class="auto-style9">
                        <asp:Label ID="Label1" runat="server" Text="Label" CssClass="auto-style14"></asp:Label>
                    </td>
                    <td class="auto-style7">
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" style="height: 22px" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Banco Fonemas"></asp:Label>
        </p>
        <table class="auto-style15">
            <tr>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton13" runat="server" CssClass="auto-style16" Height="120px" Width="120px" />
                </td>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton14" runat="server" CssClass="auto-style19" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton15" runat="server" CssClass="auto-style20" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton16" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton17" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton18" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton19" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton20" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton21" runat="server" Height="120px" Width="120px" />
                </td>
            </tr>
            <tr>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton22" runat="server" Height="120px" Width="120px" />
                </td>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton25" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton28" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton29" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton30" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton37" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton40" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton43" runat="server" Height="120px" Width="120px"/>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton46" runat="server" Height="120px" Width="120px"/>
                </td>
            </tr>
            <tr>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton23" runat="server" Height="120px" Width="120px" />
                </td>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton26" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton36" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton35" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton31" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton38" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton41" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton44" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton47" runat="server" Height="120px" Width="120px" />
                </td>
            </tr>
            <tr>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton24" runat="server" Height="120px" Width="120px" />
                </td>
                <td class="auto-style18">
                    <asp:ImageButton ID="ImageButton27" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton34" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton33" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton32" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton39" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton42" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton45" runat="server" Height="120px" Width="120px" />
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton48" runat="server" Height="120px" Width="120px" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
