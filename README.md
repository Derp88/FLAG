# Flight Logger And Grapher (FLAG)

## About
The purpose of this tool is to log flights in a defined area (For this project this will be the general Indianapolis metro area) and graph the paths of these aircraft onto a map.

## Area
This project maps the area in a bounding box with the top left corner at Lat: 40.770443 Long: -87.525964.
The bottom right corner is at Lat: 39.567746 Long: -84.815118.


## Credits
- JSON handling via Google's [json-simple](https://code.google.com/archive/p/json-simple/).
- DigitalOcean's [example](https://www.digitalocean.com/community/tutorials/json-simple-example) on how to use json-simple.
- Stackoverflow Users Raphael & Cully on the post [Mercator longitude and latitude calculations to x and y on a cropped map (of the UK)](https://stackoverflow.com/questions/2103924/mercator-longitude-and-latitude-calculations-to-x-and-y-on-a-cropped-map-of-the) for instructions and code on how to convert Longitude and Latitude to Mercator X & Y Coordinates.