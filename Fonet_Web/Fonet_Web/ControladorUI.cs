using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace Fonet_Web
{
    public sealed class ControladorUI
    {

        // The Singleton's instance is stored in a static field. There there are
        // multiple ways to initialize this field, all of them have various pros
        // and cons. In this example we'll show the simplest of these ways,
        // which, however, doesn't work really well in multithreaded program.
        private static ControladorUI _instance = new ControladorUI();
        //private Stream imagen;
        //private int tamañoimagen;
        private byte[] sonido;
        private byte[] imagen;
        // This is the static method that controls the access to the singleton
        // instance. On the first run, it creates a singleton object and places
        // it into the static field. On subsequent runs, it returns the client
        // existing object stored in the static field.
        private ControladorUI()
        {
        }

        public static ControladorUI Instance
        {
            get
            {
                return _instance;
            }
        }

        /*public void set_imagen(Stream pimage)
        {
            imagen = pimage;
        }

        public void set_tamañoimagen(int pti)
        {
            tamañoimagen = pti;
        }

        public Stream get_imagen()
        {
            return imagen;
        }

        public int get_tamañoimagen()
        {
            return tamañoimagen;
        }*/

        public void set_sonido(byte[] psonido)
        {
            sonido = psonido;
        }

        public byte[] get_sonido()
        {
            return sonido;
        }

        public void set_imagen(byte[] pimagen)
        {
            imagen = pimagen;
        }

        public byte[] get_imagen()
        {
            return imagen;
        }
    }
}