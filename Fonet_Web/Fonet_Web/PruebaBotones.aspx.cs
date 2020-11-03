using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Fonet_Web
{
    public partial class PruebaBotones : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            for (int i = 0; i <= 38; i++)
            {
                ImageButton imageButton = new ImageButton();
                //FileInfo fileInfo = new FileInfo(strFileName);
                imageButton.ImageUrl = "~/Recursos/casa.png";
                imageButton.Width = 120;
                imageButton.Height = 120;
                imageButton.BorderWidth = 10;
                imageButton.BorderColor = System.Drawing.Color.White;
                //imageButton.Attributes.Add("ID", strFileName);
                //imageButton.Attributes.Add("class", "imgOne");
                imageButton.Attributes.Add("runat", "server");
                //imageButton.Attributes.Add("OnClick", "toImageDisplay");
                this.Panel2.Controls.Add(imageButton);
            }
        }
    }
}