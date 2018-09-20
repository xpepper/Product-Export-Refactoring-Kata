﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace export
{
    /// <summary>
    /// This class contains some sample product data that you could use in your tests.
    /// </summary>
    public class SampleProducts
    {
        
        public static Product CherryBloom = new Product("Cherry Bloom", "LIPSTICK01", 30, new Price(14.99D, "USD"));
        public static Product RosePetal = new Product("Rose Petal", "LIPSTICK02", 30, new Price(14.99D, "USD"));
        public static Product BlusherBrush = new Product("Blusher Brush", "TOOL01", 50, new Price(24.99D, "USD"));
        public static Product EyelashCurler = new Product("Eyelash curler", "TOOL01", 100, new Price(19.99D, "USD"));
        public static Product WildRose = new Product("Wild Rose", "PURFUME01", 200, new Price(34.99D, "USD"));
        public static Product CocoaButter = new Product("Cocoa Butter", "SKIN_CREAM01", 250, new Price(10.99D, "USD"));

        public static Store FlagshipStore = new Store { Name = "Nordstan", Id = "4189", Stock = new List<Product> { CherryBloom }};
        public static Store BigStore = new Store { Name = "Backaplan", Id = "4189", Stock = new List<Product> { CherryBloom, RosePetal, BlusherBrush, EyelashCurler, WildRose, CocoaButter } };
        
        // Store events add themselves to the stocked items at their store
        public static Product Masterclass = new StoreEvent("Eyeshadow Masterclass", "EVENT01", FlagshipStore, new Price(119.99D, "USD"));
        public static Product Makeover = new StoreEvent("Makeover", "EVENT02", BigStore, new Price(149.99D, "USD"));

    }
    
}
