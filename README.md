# getmapgen
Desktop utility to generate GetMap requests.

About GetMap request you may read [here] (http://docs.geoserver.org/2.6.x/en/user/services/wms/reference.html#getmap).

Pattern request: 
```
?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS= &BBOX=&WIDTH=&HEIGHT=
```

Example: 
```
http://surgut.itpgrad.ru/CacheService/GetTile?FORMAT=image%2Fpng&LAYERS=SURG%3ACATALOG_65924&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&STYLES=&SRS=EPSG%3A3857&BBOX=8150614,8676958,8170181.8792375,8696525.8792375&WIDTH=256&HEIGHT=256
```

UI form has a fields:
* `Storage` - name of datastore (in example above it is keyword `SURG`);
* `Coordinate System` - coordinate system (supported only EPSG), should set only the number (for example, if coordinate system is `EPSG:3857` then you should set `3857` in the field);
* `min X, min Y, max X, max Y` - bounding box for map extent, values should be in units of the Spatial Reference System for map;
* `Zooms` - list of map scales;
* `Layers` - list of IDs of layers (in example above it is keyword `65924`);
* `Host` - host address, for example `http://surgut.itpgrad.ru/` or `http://192.168.1.1/`;
* `Pattern Query` - default pattern of GetMap request is `CacheService/GetTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=`, pattern may vary (for example you may set `CacheTile?FORMAT=&LAYERS=&SERVICE=&VERSION=&REQUEST=&STYLES=&SRS=&BBOX=&WIDTH=&HEIGHT=`, but it should not violate the pattern request shown above).

The other parameters in GetMap request are set with default values (note parameter `STYLES` is ignored):
* `FORMAT` = image%2Fpng;
* `SERVICE` = WMS;
* `VERSION` = 1.1.1;
* `REQUEST` = GetMap;
* `WIDTH` = 256;
* `HEIGHT` = 256.
