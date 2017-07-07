# multi-part-playlist-shuffler
Shuffles M3U playlists containing multipart songs so that groups of multipart songs play properly
Multipart songs could be entire albums, songs with a part1 and part2, anything that one wants an enforced ordering for while still having access to shuffle. 

## Usage
To use, call `java main.Main path_to_file_containing_aggregate_playlists`

The file containing the aggregate plalists has 2 items per line: the path to the m3u playlist on your computer, and then the number of items per set in that playlist. Each playlist has to be in agreement with the number of items per group specified in the aggregate playlist file.

For example, a file containing book (??) playlists might be:

### Aggregate Playlists
```
/path/to/singles.m3u 1
/path/to/duologies.m3u 2
/path/to/septologies.m3u 7
```

And each file might look like:

### singles.m3u
```
  #EXTM3U
  #EXT info, i dont know
  /path/to/1984 - George Orwell
  #More ext info, idk
  /path/to/1948 - Orge Geowell
```

### duologies.m3u
```
  #EXTM3U
  #EXT info
  /path/to/The Old Testament
  /path/to/The New Testament
```

### septologies.m3u
```
  #EXTM3U
  #extinfo
  /path/to/A Game of Thrones
  #extinfo
  /path/to/A Clash of Kings
  #extinfo
  /path/to/A Storm of Swords
  #extinfo
  /path/to/A Feast for Crows
  #extinfo
  /path/to/A Dance with Dragons
  #extinfo
  /path/to/The Winds of Winter
  #extinfo
  /path/to/A Dream of Spring
  #extinfo
  /path/to/Harry Potter and the Philosophers Stone
  #extinfo
  /path/to/Harry Potter and the Chamber of Secrets
  #extinfo
  /path/to/Harry Potter and the Prisoner of Azkaban
  #extinfo
  /path/to/Harry Potter and the Goblet of Fire
  #extinfo
  /path/to/Harry Potter and the Order of the Phoenix
  #extinfo
  /path/to/Harry Potter and the Half-Blood Prince
  #extinfo
  /path/to/Harry Potter and the Deathly Hallows
```

No empty lines in the m3u files, no spaces in the playlist aggregate file.
