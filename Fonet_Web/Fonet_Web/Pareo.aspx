<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Pareo.aspx.cs" Inherits="Fonet_Web.Pareo" %>

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
            width: 71px;
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
            bottom: 356px;
        }
        .auto-style13 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
            background-color: #006600;
        }
        .auto-style14 {
            font-family: Arial, Helvetica, sans-serif;
            color: #FFFFFF;
        }
        .auto-style15 {
            width: 60%;
            height: 442px;
            position: absolute;
            left: 46px;
            top: 129px;
        }
        .auto-style16 {
            width: 685px;
        }
        .auto-style17 {
            width: 1239px;
        }
        .auto-style18 {
            width: 1700px;
        }
        .auto-style19 {
            width: 1762px;
        }
        .auto-style20 {
            width: 1848px;
        }
        .auto-style21 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: large;
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
                            <asp:ImageButton ID="ImageButton10" runat="server" Height="30px" ImageUrl="~/Recursos/casa.png" Width="30px" />
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
                        <asp:Button ID="Button2" runat="server" BorderStyle="None" CssClass="auto-style13" OnClick="Button2_Click" Text="Cerrar Sesión" Width="115px" />
                    </td>
                </tr>
            </table>
            <asp:Label ID="Label2" runat="server" CssClass="auto-style12" Text="Pareo"></asp:Label>
        </p>
        <table class="auto-style15">
            <tr>
                <td>
                    <asp:Image ID="Image1" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label3" runat="server" CssClass="auto-style21" Text="1."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton13" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image2" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label4" runat="server" CssClass="auto-style21" Text="2."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton14" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image3" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label5" runat="server" CssClass="auto-style21" Text="3."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton15" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image4" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label6" runat="server" CssClass="auto-style21" Text="4."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton16" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image5" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label7" runat="server" CssClass="auto-style21" Text="5."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton17" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image6" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label8" runat="server" CssClass="auto-style21" Text="6."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton18" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image7" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox7" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label9" runat="server" CssClass="auto-style21" Text="7."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton19" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image8" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox8" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label10" runat="server" CssClass="auto-style21" Text="8."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton20" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image9" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox9" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label11" runat="server" CssClass="auto-style21" Text="9."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton21" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
            <tr>
                <td>
                    <asp:Image ID="Image10" runat="server" Height="50px" Width="50px" />
                </td>
                <td class="auto-style17">
                    <asp:TextBox ID="TextBox10" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style18">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style19">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style20">&nbsp;</td>
                <td class="auto-style16">
                    <asp:Label ID="Label12" runat="server" CssClass="auto-style21" Text="10."></asp:Label>
                </td>
                <td>
                    <asp:ImageButton ID="ImageButton22" runat="server" Height="50px" ImageUrl="~/Recursos/altavoz.png" Width="50px" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
